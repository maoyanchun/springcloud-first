package com.micro.example.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by mycge on 2018/4/16.
 */
@EnableEurekaClient  //@EnableDiscoveryClient
@SpringBootApplication
public class CustomerBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(CustomerBootStrap.class, args);
    }
}
