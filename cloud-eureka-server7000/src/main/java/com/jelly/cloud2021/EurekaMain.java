package com.jelly.cloud2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/10 13:23
 * @desc
 */
@SpringBootApplication
@EnableEurekaServer //表明自身是服务注册中心
public class EurekaMain {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain.class,args);
    }
}

/*
*引入eureka server依赖
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
配置yml,开启EnableEurekaServer

引入eureka client依赖  尤其需要注意报名引入是否正确
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
配置yml,开启EnableEurekaClient
* */