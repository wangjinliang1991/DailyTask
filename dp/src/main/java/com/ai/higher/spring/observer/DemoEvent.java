package com.ai.higher.spring.observer;

import org.springframework.context.ApplicationEvent;

/**
 * @Description: Event事件
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
public class DemoEvent extends ApplicationEvent {
    private String message;
    public DemoEvent(Object source,String message) {
        super(source);
    }
    public String getMessage(){
        return this.message;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
