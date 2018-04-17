package com.micro.example.controller;

import com.micro.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mycge on 2018/4/17.
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping("/getPayment")
    public String getPayment(Integer a, Integer b){
        return paymentService.getPayment(a, b);
    }

}
