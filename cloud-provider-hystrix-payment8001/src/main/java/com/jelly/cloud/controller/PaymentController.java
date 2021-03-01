package com.jelly.cloud.controller;

import com.jelly.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/16 15:18
 * @desc
 */
@RestController
public class PaymentController {
    @Autowired
    PaymentService service;

    @GetMapping("/payment/hystrix/ok/{id}")
    public String OkPaymentInfo(@PathVariable("id") Integer id){
        return service.okPaymentInfo(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String TimeoutPaymentInfo(@PathVariable("id") Integer id){
        return service.timeoutPaymentInfo(id);
    }

    @GetMapping("/payment/hystrix/breaker/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return service.paymentCircuitBreaker(id);
    }
}
