package com.jelly.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/16 15:56
 * @desc
 */
@Service
//service编写实现类，重写方法进行服务降级，需要配置feign.hystrix.enable:true
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceImp.class)
public interface PaymentHystrixService {
    @GetMapping("/payment/hystrix/ok/{id}")
    String OkPaymentInfo(@PathVariable("id") Integer id);
    @GetMapping("/payment/hystrix/timeout/{id}")
    String TimeoutPaymentInfo(@PathVariable("id") Integer id);
}
