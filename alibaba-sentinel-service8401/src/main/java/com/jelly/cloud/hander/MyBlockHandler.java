package com.jelly.cloud.hander;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/24 23:16
 * @desc
 */
public class MyBlockHandler {
    //注意别漏BlockException参数
    public static String handler1(BlockException exception){
        return "handler 1";
    }

    public static String handler2(BlockException exception){
        return "handler 2";
    }
}
