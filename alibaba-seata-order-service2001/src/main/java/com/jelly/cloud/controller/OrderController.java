package com.jelly.cloud.controller;

import com.jelly.cloud.domain.CommonResult;
import com.jelly.cloud.domain.Order;
import com.jelly.cloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/26 22:38
 * @desc
 */
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    /**
     * 测试链接
     * http://localhost:2001/order/create?userId=1&productId=1&count=10&money=100
     *
     * @param order
     * @return
     */
    @GetMapping("/order/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return new CommonResult(200, "订单创建完成", order);
    }
}
