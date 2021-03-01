package com.jelly.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/24 23:48
 * @desc
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderSentinelMain84 {
    public static void main(String[] args) {
        SpringApplication.run(OrderSentinelMain84.class,args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
