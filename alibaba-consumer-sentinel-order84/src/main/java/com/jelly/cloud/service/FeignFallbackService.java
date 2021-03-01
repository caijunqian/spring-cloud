package com.jelly.cloud.service;

import com.jelly.cloud2021.entity.CommonResult;
import com.jelly.cloud2021.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/25 23:59
 * @desc
 */
@Component  //记住
public class FeignFallbackService implements PaymentFeignService {
    @Override
    public CommonResult<Payment> getPayment(Long id) {
        return new CommonResult<>(444,"服务降级，fallback内容。。。",null);
    }
}
