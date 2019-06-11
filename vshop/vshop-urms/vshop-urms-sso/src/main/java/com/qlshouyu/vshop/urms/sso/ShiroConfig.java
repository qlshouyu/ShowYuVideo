package com.qlshouyu.vshop.video.manager.web.sso;

import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.config.ShiroConfiguration;
import org.apache.shiro.spring.web.config.ShiroWebConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.*;

/**
 * shiro配置
 *
 * @author 高露 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * @since 2019-06-09 16:35
 */
@Configuration
@AutoConfigureBefore(value = {ShiroWebConfiguration.class})
@ComponentScan(basePackages = {"org.apache.shiro.spring"},excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {ShiroConfiguration.class}))
public class ShiroConfig {

    @Bean
    public AuthorizingRealm authorizingRealm(){
        MyShiroRealm realm=new MyShiroRealm();
        return realm;
    }
}
