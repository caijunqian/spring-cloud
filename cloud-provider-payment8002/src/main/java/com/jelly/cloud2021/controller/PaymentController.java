package com.jelly.cloud2021.controller;

import com.jelly.cloud2021.entity.CommonResult;
import com.jelly.cloud2021.entity.Payment;
import com.jelly.cloud2021.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/10 10:56
 * @desc
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    PaymentService service;

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        Payment payment = service.getPayment(id);
        if(payment!=null){
            log.info("  select result is :"+payment);
            return new CommonResult<Payment>(200,"port:"+port+"select successfully",payment);
        }
        return new CommonResult<Payment>(400,"select failed",null);
    }

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> createPayment(@RequestBody Payment payment){
        int result = service.create(payment);
        if(result > 0){
            log.info("insert result is "+payment);
            return new CommonResult<Payment>(200,"insert successfully",payment);
        }
        return new CommonResult<Payment>(400,"insert failed",null);
    }
}
