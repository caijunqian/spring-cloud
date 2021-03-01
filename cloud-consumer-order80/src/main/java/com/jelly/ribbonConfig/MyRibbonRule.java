package com.jelly.ribbonConfig;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/13 14:00
 * @desc
 */
@Configuration
public class MyRibbonRule {
    @Bean
    public IRule MyRule(){
//        return new RandomRule();
        return new RoundRobinRule();
    }

}
