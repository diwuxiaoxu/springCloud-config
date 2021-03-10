package com.hyl.springcloud.service;

import org.springframework.stereotype.Component;

@Component

public class PaymentFallbackService implements PaymentHystrixService {
    //服务端出错，统一异常处理接口
    @Override
    public String paymentInfo_OK(Integer id) {
        return "统一处理方法";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "统一处理方法";
    }
}
