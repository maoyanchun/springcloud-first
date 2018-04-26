package com.micro.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by mycge on 2018/4/17.
 */
@EnableFeignClients//(basePackages = "com.micro.example")  //@EnableFeignClients开启Feign
@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = "com.micro.example")
public class PaymentBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(PaymentBootStrap.class, args);
    }
}
