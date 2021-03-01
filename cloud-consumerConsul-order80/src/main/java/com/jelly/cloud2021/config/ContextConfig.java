package com.jelly.cloud2021.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/12 15:26
 * @desc
 */
@Configuration
public class ContextConfig {
    @Bean
    @LoadBalanced //开启负载均衡，访问服务
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
