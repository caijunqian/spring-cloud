package com.jelly.cloud2021.dao;

import com.jelly.cloud2021.entity.Payment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * @author 2726868668@qq.com
 * @date 2021/2/9 22:41
 * @desc
 */
@Mapper
public interface PaymentDao {
    @Insert("insert into payment (serial) values(#{serial})")
    @Options(useGeneratedKeys = true)
    int create(Payment payment);

    @Select("select * from payment where id = #{id}")
    Payment getPayment(Long id);
}
