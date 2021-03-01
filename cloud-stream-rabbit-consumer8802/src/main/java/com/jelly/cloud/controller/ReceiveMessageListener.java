package com.jelly.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/22 22:58
 * @desc
 */
//消费者使用Sink和StreamListener
@Controller
@EnableBinding(Sink.class)
public class ReceiveMessageListener {
    @Value("${server.port}")
    private String port;

    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message){
        System.out.println(port+": 消费者1号，接收到消息："+message.getPayload());
    }
}
