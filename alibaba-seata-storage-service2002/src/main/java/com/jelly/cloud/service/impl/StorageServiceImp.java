package com.jelly.cloud.service.impl;

import com.jelly.cloud.dao.StorageDao;
import com.jelly.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/26 22:56
 * @desc
 */
@Service
@Slf4j
public class StorageServiceImp implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------------->storage-service 中扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("------------->storage-service 中扣减库存结束");
    }

}