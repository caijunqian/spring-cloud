package com.jelly.cloud2021.controller;

import com.jelly.cloud2021.entity.CommonResult;
import com.jelly.cloud2021.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/10 12:02
 * @desc
 */
@RestController
@Slf4j
public class OrderController {
//    public static final String PAYMENT_BASE_URL = "http://localhost:8001";

    //服务集群时，访问服务名称  配合@LoadBalanced 开启负载均衡，访问服务
    public static final String PAYMENT_BASE_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_BASE_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_BASE_URL + "/payment/get/" + id, CommonResult.class);
    }

    //用于测试zipkin
    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        return restTemplate.getForObject(PAYMENT_BASE_URL+"/payment/zipkin",String.class);
    }
}
