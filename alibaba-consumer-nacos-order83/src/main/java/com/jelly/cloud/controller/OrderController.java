package com.jelly.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/23 22:22
 * @desc
 */
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    //从配置信息中读取服务名地址，nacos自带负载均衡
    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id ){
        return restTemplate.getForObject(serverUrl+"/payment/nacos/"+id,String.class);
    }

}
