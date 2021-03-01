package cloud2021;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/12 14:39
 * @desc
 */
@SpringBootApplication
@EnableDiscoveryClient  //开启zookeeper注册为Client
public class PaymentMain8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class,args);
    }
}
