package com.micro.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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

    @HystrixCommand(fallbackMethod = "getIndexError")
    public String getIndex(){
        //Hystrix 默认超时时间为 2000 毫秒
        return restTemplate.getForObject("http://customer-business-service/index", String.class);
    }

    @HystrixCommand(fallbackMethod = "getOrderError")
    public String getOrder(Integer a, Integer b){
        return restTemplate.getForObject("http://customer-business-service/show?a="+a+"&b="+b, String.class);
    }

    public String getIndexError(){
        return "ERROR getIndex order";
    }

    public String getOrderError(Integer a, Integer b){
        return "ERROR getOrder order。 params:a="+a+", b="+b;
    }
}
