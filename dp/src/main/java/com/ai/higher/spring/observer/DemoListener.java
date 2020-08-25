package com.ai.higher.spring.observer;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Description: listener监听者
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String message = demoEvent.getMessage();
        System.out.println(message);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
