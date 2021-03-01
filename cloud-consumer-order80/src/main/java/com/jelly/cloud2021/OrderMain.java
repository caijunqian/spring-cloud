package com.jelly.cloud2021;

import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/10 11:48
 * @desc
 */
@SpringBootApplication
@EnableEurekaClient
//name = "cloud-payment-service"大小写要和配置文件一致  自定义负载均衡规则测试失败
@RibbonClient(name = "cloud-payment-service")//,configuration = com.jelly.ribbonConfig.MyRibbonRule.class
public class OrderMain {

    @Bean
    public RandomRule createRule(){
        return new RandomRule();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class,args);
    }
}
/*****
 * 新版的eureka默认集成了ribbon，ribbon的负载均衡默认使用轮询算法
 * 可以指定某特定的微服务使用的负载均衡算法
 * 1.自定义configuration类，把指定的负载均衡策略类加入spring容器
 * 2.在主启动类上加入@RibbonClient注解，
 * @RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyRibbonRule.class)
 */
