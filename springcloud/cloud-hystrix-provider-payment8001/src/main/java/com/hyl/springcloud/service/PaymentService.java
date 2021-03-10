package com.hyl.springcloud.service;

import com.hyl.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);


    //===测试hystrix的服务降级
    public String paymentInfo_OK(Integer id);
    public String paymentInfo_TimeOut(Integer id);


    //===测试服务熔断
    public String paymentCircuitBreaker(Integer id);

}
