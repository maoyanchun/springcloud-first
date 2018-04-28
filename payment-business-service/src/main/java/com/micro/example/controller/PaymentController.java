package com.micro.example.controller;

import com.micro.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mycge on 2018/4/17.
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${neo.hello}")
    private String hello;

    @RequestMapping("/hello")
    public String hello(){
        return this.hello;
    }

    @RequestMapping("getIndex")
    public String getIndex(){
        return paymentService.getIndex();
    }

    @RequestMapping("/getPayment")
    public String getPayment(Integer a, Integer b){
        return paymentService.getPayment(a, b);
    }

}
