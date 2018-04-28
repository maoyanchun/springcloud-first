package com.micro.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @EnableCircuitBreaker 开启断路器功能
 * Created by mycge on 2018/4/17.
 */
@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication  //(scanBasePackages = "com.micro.example") 扫包默认同级包目录
public class OrderBootStrap {

    public static void main(String[] args) {
        SpringApplication.run(OrderBootStrap.class, args);
    }

    @Bean
    @LoadBalanced    //@LoadBalanced表明这个restTemplate是负载均衡的
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
