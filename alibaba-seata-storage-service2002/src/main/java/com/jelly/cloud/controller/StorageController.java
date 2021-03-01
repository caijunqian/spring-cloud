package com.jelly.cloud.controller;

import com.jelly.cloud.domain.CommonResult;
import com.jelly.cloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/26 22:55
 * @desc
 */
@RestController
@Slf4j
public class StorageController {
    @Resource
    private StorageService storageService;

    @RequestMapping(value = "/storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId,
                                 @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功");
    }
}
