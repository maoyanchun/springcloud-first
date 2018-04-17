package com.micro.example.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign接口
 * Created by mycge on 2018/4/17.
 */
@FeignClient("customer-business-service")
public interface PaymentService {

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String getPayment(@RequestParam("a") Integer a, @RequestParam("b") Integer b);
}
