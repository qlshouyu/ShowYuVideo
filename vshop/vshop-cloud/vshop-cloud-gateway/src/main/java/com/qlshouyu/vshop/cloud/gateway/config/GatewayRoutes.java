package com.qlshouyu.vshop.cloud.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 高露 微信：18956074544
 * @Description TODO
 * @date 2019-06-01 21:36
 */
@Configuration
public class GatewayRoutes {
//    @Bean
//    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route(r ->
//                        r.path("/java/**")
//                                .filters(
//                                        f -> f.stripPrefix(1)
//                                )
//                                .uri("http://localhost:8081/api/admin/v1/dictionary")
//                )
//                .build();
//    }
}
