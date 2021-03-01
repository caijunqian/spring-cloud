package com.jelly.cloud2021.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/9 22:31
 * @desc
 */

@Data
@Accessors(chain = true)
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
