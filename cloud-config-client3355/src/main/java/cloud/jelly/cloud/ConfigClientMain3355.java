package cloud.jelly.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/20 15:41
 * @desc
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigClientMain3355 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientMain3355.class,args);
    }
}

/*
当github配置代码发生改变时，config center3344会自动拉取更新
而config客户端3355则必须重启服务才能响应更新，
不重启动态刷新的步骤：
1.3355引入actuator依赖
2.修改yml暴露监控端口
management:
  endpoints:
    web:
      exposure:
        include: "*"
3.在3355获取配置的Controller上添加注解@RefreshScope
4.向3355发送请求，通知其刷新配置信息
    curl -X POST "http://localhost:3355/actuator/refresh"
 */