package com.jelly.cloud.service;

import com.jelly.cloud2021.entity.CommonResult;
import com.jelly.cloud2021.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/25 23:42
 * @desc
 */
@Service    //alibaba-sentinel-service  当feig所调用的服务异常时，FeignFallbackService的fallback生效
@FeignClient(value = "alibaba-sentinel-service",fallback = FeignFallbackService.class) //FeignClient注解把service接口的调用都映射到微服务对应的controller层
public interface PaymentFeignService {

    @GetMapping("/payment/{id}")
    CommonResult<Payment> getPayment(@PathVariable("id") Long id);
}
