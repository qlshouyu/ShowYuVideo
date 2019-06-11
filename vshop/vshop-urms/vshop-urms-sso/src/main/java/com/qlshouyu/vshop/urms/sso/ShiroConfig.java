package com.qlshouyu.vshop.urms.sso;

import com.qlshouyu.vshop.urms.sso.filters.CORSAuthenticationFilter;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.config.ShiroConfiguration;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.spring.web.config.ShiroWebConfiguration;
import org.apache.shiro.spring.web.config.ShiroWebFilterConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
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
@AutoConfigureBefore(value = {ShiroWebConfiguration.class})
@ComponentScan(basePackages = {"org.apache.shiro.spring"},
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                classes = {ShiroConfiguration.class, ShiroWebFilterConfiguration.class
}))
public class ShiroConfig {

    @Bean
    public AuthorizingRealm authorizingRealm(){
        MyShiroRealm realm=new MyShiroRealm();
        return realm;
    }

    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(org.apache.shiro.mgt.SecurityManager securityManager,CORSAuthenticationFilter corsAuthenticationFilter) {
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
        filterChainDefinitionMap.put("/**", "corsAuthenticationFilter");
        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //自定义过滤器
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("corsAuthenticationFilter", corsAuthenticationFilter);
        shiroFilter.setFilters(filterMap);

        return shiroFilter;
    }

    @Bean
    public CORSAuthenticationFilter corsAuthenticationFilter(){
        return new CORSAuthenticationFilter();
    }
}
