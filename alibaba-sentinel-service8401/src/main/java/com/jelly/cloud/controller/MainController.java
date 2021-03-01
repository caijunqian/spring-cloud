package com.jelly.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jelly.cloud.hander.MyBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/24 21:52
 * @desc
 */
@RestController
public class MainController {
    @GetMapping("/test/a")
    public String testA(){
        System.out.println("test A");
        return "testA";
    }

    @GetMapping("/test/b")
    @SentinelResource(value = "testB",blockHandlerClass = MyBlockHandler.class,blockHandler = "handler1")
    public String testB(){
        System.out.println("test B");
        return "testB";
    }


    @GetMapping("/testHotkey")
    @SentinelResource(value = "testHotkey",blockHandler = "dealHotKey")
    public String testHotKey2(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "==========test hot key!";
    }

    public String dealHotKey(String p1, String p2, BlockException exception){
        //sentinel 默认的提示为：blocked by sentinel (blow limiting)
        return "========== deal !!! test hot key!";
    }
}
