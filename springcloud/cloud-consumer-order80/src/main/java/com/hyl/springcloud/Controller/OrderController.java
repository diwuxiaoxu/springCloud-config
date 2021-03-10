package com.hyl.springcloud.Controller;

import com.hyl.springcloud.entities.CommonResult;
import com.hyl.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    // 客户端调用服务端，只需要controller就可以了，使用restTemplate进行http的访问过程

//    public static final String PAYMENT_URL = "http://localhost:8001"; 单机版

    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

//    public static final String PAYMENT_URL ="http://cloud-payment-service";  zookeeper

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create (Payment payment){

        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id, CommonResult.class);
    }

    // 服务发现
    @GetMapping("/consumer/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();

        for (String service : services) {
            log.info("service:"+service);
        }
        return this.discoveryClient;
    }
}
