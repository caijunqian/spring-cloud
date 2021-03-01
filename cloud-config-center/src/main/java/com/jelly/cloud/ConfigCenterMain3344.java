package com.jelly.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/20 15:18
 * @desc
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer //增加注解
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class,args);
    }
}
/*
使用bus总线后，只需要向3344发请求，由于ConfigClient实例都监听MQ中同一个topic （默认为springCloudBus）
,当3344刷新时，其他config client会同通过mq的订阅得到通知，然后去更新自身配置
curl -X POST "http://localhost:3344/actuator/bus-refresh"
也可指定服务进行通知
curl -X POST "http://localhost:3344/actuator/bus-refresh/cloud-config-client:3355"
**/
