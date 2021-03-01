package com.jelly.cloud2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/9 22:16
 * @desc
 */
@SpringBootApplication
@EnableEurekaClient //向服务中心注册
@EnableDiscoveryClient  //暴露本服务相关信息的接口
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class,args);
    }
}
