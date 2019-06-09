package com.qlshouyu.vshop.urms.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = {"com.qlshouyu.vshop"})
@EnableEurekaClient
public class UrmsAdminApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UrmsAdminApiApplication.class, args);
    }

}
