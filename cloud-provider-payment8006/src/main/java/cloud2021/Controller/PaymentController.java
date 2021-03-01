package cloud2021.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/12 14:47
 * @desc
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/consul")
    public String paymentConsul(){
        return "spring cloud with consul:"+port+"\t"+ UUID.randomUUID().toString();
    }
}


