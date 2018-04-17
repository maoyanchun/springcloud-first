package com.micro.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by mycge on 2018/4/16.
 */
@RestController
public class CustomerController {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String show(@RequestParam(required = false, defaultValue = "1") Integer a, @RequestParam(required = false, defaultValue = "1") Integer b){
        Integer result = a+b;
        return "show Customer Info: a + b = "+result+"  ,port="+port;
    }
}
