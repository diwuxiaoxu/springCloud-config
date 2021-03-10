package com.hyl.springcloud.controller;

import com.hyl.springcloud.entities.CommonResult;
import com.hyl.springcloud.entities.Payment;
import com.hyl.springcloud.service.PaymentOpenfeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderOpenfeignController {

    @Resource
    private PaymentOpenfeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return paymentFeignService.create(payment);
    }
}
