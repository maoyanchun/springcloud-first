package com.micro.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Created by mycge on 2018/4/17.
 */
@EnableFeignClients(basePackages = "com.micro.example")  //@EnableFeignClients开启Feign
@EnableEurekaClient
@SpringBootApplication
public class PaymentBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(PaymentBootStrap.class, args);
    }
}
