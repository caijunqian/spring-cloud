package com.jelly.cloud.service;

import org.springframework.stereotype.Service;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/17 19:49
 * @desc
 */
@Service
public class PaymentHystrixServiceImp implements PaymentHystrixService{
    @Override
    public String OkPaymentInfo(Integer id) {
        return "Service fallback in OkPaymentInfo";
    }

    @Override
    public String TimeoutPaymentInfo(Integer id) {
        return "Service fallback in TimeoutPaymentInfo";
    }
}
