package com.jelly.cloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/26 15:13
 * @desc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private long productId;
    private Integer count;
    private BigDecimal money;
    /**
     * //订单状态:  0:创建    1:已完成
     */
    private Integer status;

}
