package com.hyl.springcloud.dao;

import com.hyl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;


@Mapper
public interface PaymentDao {
    public int create(Payment payment);
    public Payment getPaymentById(Long id);
}
