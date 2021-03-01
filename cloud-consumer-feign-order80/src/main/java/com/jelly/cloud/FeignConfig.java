package com.jelly.cloud;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/16 14:51
 * @desc
 */
//日志控制类,配置后在application.yml中开启feignClient接口所在的包日志监控
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        //NONE:默认，不显示日志
        //BASIC:仅记录请求方法，url响应状态码，执行时间
        //HEADERS:Basic+请求头和响应头信息
        //FULL:HEADERS+请求和响应正文及数据
        return Logger.Level.FULL;
    }
}
