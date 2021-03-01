package com.jelly.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/20 1:46
 * @desc
 */
//配置路由映射规则可以在yml中也可通过Bean的方式
@Configuration
public class GatewayConfig {
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
//        RouteLocatorBuilder.Builder routes = builder.routes();
//        routes.route("path_route1",r -> r.path("/payment/lb")
//                .uri("http://localhost:8001/payment/lb")).build();
//        //访问localhost:9527/payment/lb，会转发到http://localhost:8001/payment/lb
//        return routes.build();
//    }
}
