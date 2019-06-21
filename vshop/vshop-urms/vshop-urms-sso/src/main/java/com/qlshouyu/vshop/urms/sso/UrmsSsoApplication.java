package com.qlshouyu.vshop.urms.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * TODO
 *
 * @author 高露
 * 邮箱：<a href="egojit@qq.com">egojit@qq.com</a>
 * 微信：<a href="egojit">egojit</a>
 * @since 19-6-21下午2:43
 */
@SpringBootApplication(scanBasePackages = {"com.qlshouyu.vshop"})
public class UrmsSsoApplication {
    public static void main(String[] args) {
        SpringApplication.run(UrmsSsoApplication.class, args);
    }
}
