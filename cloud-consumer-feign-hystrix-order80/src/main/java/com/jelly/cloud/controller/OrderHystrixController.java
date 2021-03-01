package com.jelly.cloud.controller;

import com.jelly.cloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/16 15:59
 * @desc
 */

/***
 * 可以在Controller中降级编写fallback方法，也可在Service层进行fallback编写
 */

@RestController
//设置一个全局的fallback Method
//凡是配置了@HystrixCommand注解的方法进行降级时都对应该全局fallback
@DefaultProperties(defaultFallback = "paymentGlobalFallback")
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    //全局的fallback
    public String paymentGlobalFallback(){
        return "这是全局异常处理信息！！！";
    }

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    @HystrixCommand //没指定fallback则使用全局的
    public String okPaymentInfo(@PathVariable("id") Integer id){
        int a = 1/0;    //模拟异常
        return paymentHystrixService.OkPaymentInfo(id);
    }


    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "timeoutPaymentInfoHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    String timeoutPaymentInfo(@PathVariable("id") Integer id){
        //int a = 1/0;
        return paymentHystrixService.TimeoutPaymentInfo(id);
    }

    //普通fallbackMethod的参数必须和原方法一致
    String timeoutPaymentInfoHandler(Integer id){
        return id+" 80 Order,运行出错 或 8001支付系统繁忙，请稍后再试。";
    }


    @GetMapping("/consumer/payment/hystrix/timeout/service/{id}")
    @HystrixCommand(fallbackMethod = "timeoutPaymentInfoHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })
    String timeoutFallbackInService(@PathVariable("id") Integer id){
        return paymentHystrixService.TimeoutPaymentInfo(id);
    }
}
