package com.micro.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by mycge on 2018/4/16.
 */
@RestController
public class CustomerController {

    @Value("${server.port}")
    private String port;

    @Value("${neo.hello}")
    private String hello; //服务配置中心config-server获取

    @RequestMapping("/hello")
    public String hello(){
        return this.hello;
    }

    @RequestMapping("/index")
    public String index(){
        System.out.println("*********************customer index()*********************");

        int sleepTime = new Random().nextInt(5000);

        try {
            Thread.sleep(sleepTime); //Hystrix 默认超时时间为 2000 毫秒
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "index From customer, sleepTime="+sleepTime;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(@RequestParam(required = false, defaultValue = "1") Integer a, @RequestParam(required = false, defaultValue = "1") Integer b){
        System.out.println("*********************customer show()*********************");

        Integer result = a+b;
        return "show Customer Info: a + b = "+result+"  ,port="+port;
    }
}
