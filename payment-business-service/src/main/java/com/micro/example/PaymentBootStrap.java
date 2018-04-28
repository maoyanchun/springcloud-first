package com.micro.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @EnableFeignClients 开启Feign
 * Created by mycge on 2018/4/17.
 */

@EnableFeignClients  //(basePackages = "com.micro.example") 扫包默认同级包目录
@EnableEurekaClient
@SpringBootApplication
public class PaymentBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(PaymentBootStrap.class, args);
    }
}
