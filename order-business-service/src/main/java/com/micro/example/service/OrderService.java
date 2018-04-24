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

    @HystrixCommand(fallbackMethod = "indexError")
    public String getIndex(){
        //Hystrix 默认超时时间为 2000 毫秒
        return restTemplate.getForObject("http://customer-business-service/index", String.class);
    }

    @HystrixCommand(fallbackMethod = "helloError")
    public String getOrder(Integer a, Integer b){
        return restTemplate.getForObject("http://customer-business-service/show?a="+a+"&b="+b, String.class);
    }

    public String indexError(){
        return "getIndex error";
    }

    public String helloError(Integer a, Integer b){
        return "error page. params:a="+a+", b="+b;
    }
}
