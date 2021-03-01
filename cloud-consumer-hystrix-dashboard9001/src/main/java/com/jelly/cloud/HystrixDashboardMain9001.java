package com.jelly.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/17 20:48
 * @desc
 */
@SpringBootApplication
@EnableHystrixDashboard //受监控的微服务需要引入actuator和web依赖
public class HystrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }

    //解决cloud版本升级的遗留问题   运行失败。。。。
//   @Bean
//   public ServletRegistrationBean getServlet(){
//       HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
//       ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(streamServlet);
//       servletRegistrationBean.setLoadOnStartup(1);
//       servletRegistrationBean.addUrlMappings("/hystrix.stream");
//       servletRegistrationBean.setName("HystrixMetricsStreamServlet");
//       return servletRegistrationBean;
//   }
}
