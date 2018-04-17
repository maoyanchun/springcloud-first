package com.micro.example.controller;

import com.micro.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mycge on 2018/4/17.
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping("getOrder")
    public String getOrder(@RequestParam(required = false, defaultValue = "2") Integer a, @RequestParam(required = false,defaultValue = "2") Integer b){
        return orderService.getOrder(a, b);
    }
}
