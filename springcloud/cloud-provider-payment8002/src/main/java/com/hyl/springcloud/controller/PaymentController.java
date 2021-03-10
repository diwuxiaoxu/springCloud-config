package com.hyl.springcloud.controller;

import com.hyl.springcloud.entities.CommonResult;
import com.hyl.springcloud.entities.Payment;
import com.hyl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private  PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    //restful风格 : 写操作用PostMapping 读操作用GetMapping, 但浏览器并不直接支持发post请求postMapping, 使用requestMapping
    //  可以使用postman软件测试post请求
    @RequestMapping(value = "/payment/create")
    public CommonResult create( Payment payment){
        int result = paymentService.create(payment);
        log.info("*****插入结果："+result );
        if (result>0){  //成功
            return new CommonResult(200,"插入数据库成功,serverPort" + serverPort,result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        System.out.println(payment);
        log.info("*****查询结果："+payment);
        if (payment!=null){  //说明有数据，能查询成功
            return new CommonResult(200,"查询成功,serverPort" + serverPort,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id,null);
        }
    }
}

