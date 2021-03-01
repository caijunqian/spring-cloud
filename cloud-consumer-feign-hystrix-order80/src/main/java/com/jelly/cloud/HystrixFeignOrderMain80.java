package com.jelly.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/16 15:55
 * @desc
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class HystrixFeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixFeignOrderMain80.class,args);
    }
}
