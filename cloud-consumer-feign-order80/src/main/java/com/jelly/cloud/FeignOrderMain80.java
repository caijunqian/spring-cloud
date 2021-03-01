package com.jelly.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/16 14:17
 * @desc
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class FeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(FeignOrderMain80.class,args);
    }
}
