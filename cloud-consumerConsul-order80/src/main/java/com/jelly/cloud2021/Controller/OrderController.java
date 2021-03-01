package com.jelly.cloud2021.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/12 15:27
 * @desc
 */
@RestController
public class OrderController {
    public static final String BASE_URL = "http://consul-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String paymentInfo(){
        return restTemplate.getForObject(BASE_URL+"/payment/consul",String.class);
    }
}
