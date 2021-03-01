package com.jelly.cloud.dao;

import com.jelly.cloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/26 15:18
 * @desc
 */
@Mapper
public interface OrderDao {
    /**
     * 创建订单
     */
    void create(Order order);

    /**
     * 修改订单状态
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
