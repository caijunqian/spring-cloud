package com.jelly.cloud2021.service;

import com.jelly.cloud2021.dao.PaymentDao;
import com.jelly.cloud2021.entity.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/10 10:54
 * @desc
 */
@Service
public class PaymentService {
    @Autowired
    PaymentDao dao;
    public int create(Payment payment){
        return dao.create(payment);
    }

    public Payment getPayment(Long id) {
        return dao.getPayment(id);
    }
}
