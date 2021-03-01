package com.jelly.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/16 15:17
 * @desc
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker   //消费端是@EnableHystrix 并且需要在yml中配置开启feign的hystrix
public class PaymentHystrixMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }
}
