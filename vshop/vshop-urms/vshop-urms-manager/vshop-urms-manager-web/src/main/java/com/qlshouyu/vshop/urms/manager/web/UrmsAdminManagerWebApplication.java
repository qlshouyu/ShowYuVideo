package com.qlshouyu.vshop.urms.manager.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.qlshouyu.vshop"})
@EnableEurekaClient
public class UrmsAdminManagerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrmsAdminManagerWebApplication.class, args);
    }

}
