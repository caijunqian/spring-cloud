package com.jelly.cloud.controller;

import com.jelly.cloud.service.impl.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/22 15:33
 * @desc
 */
@RestController
public class SendMessageController {
    @Autowired
    private MessageProvider messageProvider;

    @GetMapping("/send")
    public String sendMessage(){
        messageProvider.send();
        return "success";
    }
}
