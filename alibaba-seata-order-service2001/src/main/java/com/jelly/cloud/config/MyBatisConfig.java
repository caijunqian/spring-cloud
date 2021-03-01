package com.jelly.cloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.jelly.cloud.dao")
public class MyBatisConfig {
}
