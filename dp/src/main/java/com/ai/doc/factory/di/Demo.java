package com.ai.doc.factory.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/14
 * @Version: 1.0
 **/
public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        RateLimiter rateLimiter = (RateLimiter) context.getBean("rateLimiter");
        rateLimiter.test();
        //...
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
