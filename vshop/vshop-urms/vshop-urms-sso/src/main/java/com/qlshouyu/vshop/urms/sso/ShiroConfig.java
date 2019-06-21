package com.qlshouyu.vshop.urms.sso;

import com.qlshouyu.vshop.urms.sso.filters.JWTFilter;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.*;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置
 *
 * @author 高露 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * @since 2019-06-09 16:35
 */
@Configuration
//@AutoConfigureBefore(value = {ShiroWebConfiguration.class})
//@ComponentScan(basePackages = {"org.apache.shiro.spring"},
//        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
//                classes = {ShiroConfiguration.class, ShiroWebFilterConfiguration.class
//}))
public class ShiroConfig  {



    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(org.apache.shiro.mgt.SecurityManager securityManager,BasicHttpAuthenticationFilter filter) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        //SecurityUtils.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //配置不会被拦截的链接，顺序判断
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/static/js/**", "anon");
        filterChainDefinitionMap.put("/static/css/**", "anon");
        filterChainDefinitionMap.put("/static/fonts/**", "anon");
        filterChainDefinitionMap.put("/login/**", "anon");
        filterChainDefinitionMap.put("/corp/call_back/receive", "anon");
        //authc:所有url必须通过认证才能访问，anon:所有url都可以匿名访问
        filterChainDefinitionMap.put("/**", "jwtFilter");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //自定义过滤器
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("jwtFilter", filter);
        shiroFilter.setFilters(filterMap);

        return shiroFilter;
    }


    @Bean
    public org.apache.shiro.mgt.SecurityManager securityManager(AuthorizingRealm realm,CacheManager cacheManager,SessionManager sessionManager){
        DefaultWebSecurityManager sm = new DefaultWebSecurityManager();
        sm.setRealm(realm);
        sm.setCacheManager(cacheManager);
        //关闭shiro自带的session
        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        sm.setSubjectDAO(subjectDAO);
        return sm;
    }


    @Bean
    public AuthorizingRealm authorizingRealm(){
        MyShiroRealm realm=new MyShiroRealm();
        return realm;
    }
    @Bean
    @ConditionalOnMissingBean(CacheManager.class)
    public CacheManager cacheManager() {
        return new MemoryConstrainedCacheManager();
    }
    @Bean(name = "urms")
    public Cache cacheManager(CacheManager cacheManager) {
        return cacheManager.getCache("urms");
    }
    @Bean
    public BasicHttpAuthenticationFilter corsAuthenticationFilter(){
        return new JWTFilter();
    }

    /**
     * Shiro生命周期处理器 * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能 * @return
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(org.apache.shiro.mgt.SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

}
