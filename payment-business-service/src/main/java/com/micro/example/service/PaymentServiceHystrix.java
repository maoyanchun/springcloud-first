package com.micro.example.service;

import org.springframework.stereotype.Component;

/**
 * Created by mycge on 2018/4/24.
 */
@Component
public class PaymentServiceHystrix implements PaymentService{
    @Override
    public String getIndex() {
        return "ERROR getIndex payment";
    }

    @Override
    public String getPayment(Integer a, Integer b) {
        return "ERROR getPayment payment。 params a="+a+" ,b="+b;
    }
}
