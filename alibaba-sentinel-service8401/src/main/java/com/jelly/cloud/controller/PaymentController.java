package com.jelly.cloud.controller;

import com.jelly.cloud2021.entity.CommonResult;
import com.jelly.cloud2021.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/24 23:36
 * @desc
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    static {
        hashMap.put(1L,new Payment().setId(1L).setSerial("11111"));
        hashMap.put(2L,new Payment().setId(2L).setSerial("22222"));
        hashMap.put(3L,new Payment().setId(3L).setSerial("33333"));
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
//        int a = 1/0;模拟接口调用失败，feign的fallback生效
        Payment payment = hashMap.get(id);
        return new CommonResult<Payment>().setCode(Integer.parseInt(port)).setData(payment);
    }

}
