package com.jelly.cloud2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/12 14:39
 * @desc
 */
@SpringBootApplication
@EnableDiscoveryClient  //开启zookeeper注册为Client
public class PaymentMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class,args);
    }
}
/***
 * 安装和详细使用zookeeper docker:https://hub.docker.com/_/zookeeper
 * 启动zookeeper客户端：
 * docker run -it --rm --link some-zookeeper:zookeeper zookeeper:TAG zkCli.sh -server zookeeper
 */