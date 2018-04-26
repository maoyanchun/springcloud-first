package com.micro.example.zuul;

import com.micro.example.zuul.filter.TokenFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * Created by mycge on 2018/4/24.
 */

@EnableEurekaClient
@EnableZuulProxy  //支持路由网关
@SpringBootApplication
public class GatewayServiceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceZuulApplication.class, args);
    }

    //将TokenFilter加入到请求拦截队列
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }
}
