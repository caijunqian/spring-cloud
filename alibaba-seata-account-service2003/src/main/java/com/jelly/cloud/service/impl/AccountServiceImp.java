package com.jelly.cloud.service.impl;

import com.jelly.cloud.dao.AccountDao;
import com.jelly.cloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class AccountServiceImp implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------------->account-service 中扣减库存开始");
        //  模拟异常 配合 2001 服务里面的注解    @GlobalTransactional(name = "arbitrary-name", rollbackFor = Exception.class)
        //  导致结果,订单状态没变成已完成,库存和账户都被扣减
        //  正常测试注销try catch.
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountDao.decrease(userId, money);
        log.info("------------->account-service 中扣减库存结束");
    }
}
