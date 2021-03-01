package com.jelly.cloud2021.controller;

import com.jelly.cloud2021.entity.CommonResult;
import com.jelly.cloud2021.entity.Payment;
import com.jelly.cloud2021.service.PaymentService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private DiscoveryClient discoveryClient;    //spring cloud 包下的

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

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String s : services) {
            log.info("element:"+s);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for(ServiceInstance instance:instances){
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getLbPayment(){
        return port;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "this is 8001 payment zipkin call!";
    }
}
