package com.micro.example.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述：Spring获取上下文工具类
 * Created by mycge on 2018/4/16.
 */
@Configuration
@SuppressWarnings({ "unchecked", "rawtypes" })
public class SpringContextUtil implements ApplicationContextAware{
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static Object getBean(Class className){
        try {
            Object restTemplate = applicationContext.getBean(className);
            return  restTemplate;
        }catch (Exception e){
            return null;
        }
    }

    public static void setAppContext(ApplicationContext applicationContext){
        applicationContext = applicationContext;
    }
}
