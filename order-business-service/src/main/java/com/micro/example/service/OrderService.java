package com.micro.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by mycge on 2018/4/17.
 */
@Service
public class OrderService {

    @Autowired
    RestTemplate restTemplate;

    public String getOrder(Integer a, Integer b){
        return restTemplate.getForObject("http://customer-business-service/show?a="+a+"&b="+b, String.class);
    }
}
