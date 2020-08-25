package com.ai.higher.spring.observer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @Description: publisher发送者
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
@Component
public class DemoPublisher {
    @Autowired
    private ApplicationContext applicationContext;
    public void publishEvent(DemoEvent demoEvent){
        this.applicationContext.publishEvent(demoEvent);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
