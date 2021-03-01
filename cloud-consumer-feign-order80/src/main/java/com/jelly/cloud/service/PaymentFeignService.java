package com.jelly.cloud.service;

import com.jelly.cloud2021.entity.CommonResult;
import com.jelly.cloud2021.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/16 14:18
 * @desc
 */
@Service
@FeignClient("CLOUD-PAYMENT-SERVICE") //FeignClient注解把service接口的调用都映射到微服务对应的controller层
public interface PaymentFeignService {
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @PostMapping(value = "/payment/create")
    CommonResult<Payment> createPayment(@RequestBody Payment payment);
}
