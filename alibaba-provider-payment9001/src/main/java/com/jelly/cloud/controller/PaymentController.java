package com.jelly.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/23 22:04
 * @desc
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id ){
        return "nacos registry, serverPost: "+ port+" id:"+id;
    }
}
