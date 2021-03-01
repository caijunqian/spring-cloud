package com.jelly.cloud.service.impl;

import com.jelly.cloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/22 15:22
 * @desc
 */
//生产者使用MessageChannel和Source
@EnableBinding(Source.class)    //定义消息推送管道
public class MessageProvider implements IMessageProvider {

    @Autowired
    private MessageChannel output;  //命名为output，可唯一自动的注入

    @Override
    public void send() {
        String serial = UUID.randomUUID().toString();
        //通过下方语句把serial作为消息写入消息队列中
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println(serial);
    }
}
