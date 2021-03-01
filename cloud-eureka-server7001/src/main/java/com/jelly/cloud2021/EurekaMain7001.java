package com.jelly.cloud2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/10 14:55
 * @desc
 */
@SpringBootApplication
@EnableEurekaServer //表明自身是服务注册中心
public class EurekaMain7001 {
    public static void main(String[] args){
        SpringApplication.run(EurekaMain7001.class,args);
    }
}
