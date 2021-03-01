package com.jelly.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/16 15:18
 * @desc
 */
@Service
public class PaymentService {
    /***
     * 正常访问的
     */
    public String okPaymentInfo(Integer id){
        return "线程池:"+ Thread.currentThread().getName()+" payment info,id: "+id+"  ok!";
    }

    //超时或运行异常都会进行服务降级
    @HystrixCommand(fallbackMethod = "timeoutPaymentInfoHandler",commandProperties = {
            //超时3s则进行服务降级
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String timeoutPaymentInfo(Integer id){
        int timeout=5;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return "线程池:"+ Thread.currentThread().getName()+" payment info,id: "+id+"  TimeOut(second): "+timeout;
    }

    public String timeoutPaymentInfoHandler(Integer id){
        return "线程池:"+ Thread.currentThread().getName()+" payment info,id: "+id+"  出错了！！！ ";
    }

    /***
     * 服务熔断:
     * Closed：熔断器关闭状态，调用失败次数积累，到了阈值（或一定比例）则启动熔断机制，即转为Open状态；
     * Open：熔断器打开状态，此时对下游的调用都内部直接返回错误，不走网络，但设计了一个时钟选项，默认的时钟达到了一定时间（这个时间一般设置成平均故障处理时间，也就是MTTR），到了这个时间，进入半熔断状态；
     * Half-Open：半熔断状态，允许定量的服务请求，如果调用都成功（或一定比例）则认为恢复了，关闭熔断器，否则认为还没好，又回到熔断器打开状态；
     */
    @HystrixCommand(fallbackMethod = "breakerFallback",commandProperties = {
            //具体属性作用见官网，或源码HystrixCommandProperties.java
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//开启熔断机制
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求阈值
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时钟
            //请求达到阈值时失败率超过60则熔断，猜测
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),
    })
    public String paymentCircuitBreaker(Integer id){
        if(id<0)throw new RuntimeException("********id 不可为负数***********");
        String serial = UUID.randomUUID().toString();
        return Thread.currentThread().getName()+"\t 调用成功:"+serial;
    }
    public String breakerFallback(Integer id){
        return "id不可为负数";
    }
}
