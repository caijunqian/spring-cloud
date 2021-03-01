package com.jelly.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/21 23:19
 * @desc
 */
@RestController
@RefreshScope   //必须要加
public class ConfigController {
    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String port;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return port+": "+configInfo;
    }
}
