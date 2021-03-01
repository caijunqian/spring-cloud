package com.jelly.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jelly.cloud.service.PaymentFeignService;
import com.jelly.cloud2021.entity.CommonResult;
import com.jelly.cloud2021.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/23 22:22
 * @desc 测试服务熔断
 */
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private PaymentFeignService paymentFeignService;

    //从配置信息中读取服务名地址，nacos自带负载均衡
    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping("/consumer/payment/{id}")
    public String getPayment(@PathVariable("id") Integer id ){
        return restTemplate.getForObject(serverUrl+"/payment/"+id,String.class);
    }

    @GetMapping("/consumer/fallback/{id}")
    @SentinelResource(value = "fallback",
            blockHandler = "blockHandlerFun",
            fallback = "fallbackFun",
            exceptionsToIgnore = NullPointerException.class)    //遇到特点例外异常时，fallback不起作用
    public CommonResult<Payment> fallback(@PathVariable("id") Long id){
//        String res = restTemplate.getForObject(serverUrl+"/payment/"+id,String.class);
        CommonResult<Payment> res = paymentFeignService.getPayment(id);
        if(id==4)
            throw new IllegalArgumentException("非法参数异常.");
        else if(id == 5)
            throw new NullPointerException("空参数异常.");
        return res;
    }
    public CommonResult<Payment> blockHandlerFun(Long id, BlockException exception){
        return new CommonResult<>(555,
                "当出现违反sentinel规则时，此方法被调用，且此方法优先级高于fallback。",null);
    }
    public CommonResult<Payment> fallbackFun(Long id,Throwable throwable){
        throwable.printStackTrace();
        return new CommonResult<>(555,"当出现java内部异常时，此方法被调用。",null);
    }
}
