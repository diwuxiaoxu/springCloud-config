package com.hyl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenfeignOrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OpenfeignOrderMain80.class, args);
    }
}
