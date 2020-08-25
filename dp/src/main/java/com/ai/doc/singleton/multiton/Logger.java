package com.ai.doc.singleton.multiton;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/11
 * @Version: 1.0
 **/
public class Logger {
    private static final ConcurrentHashMap<String,Logger> instances = new ConcurrentHashMap<>();
    private Logger(){}
    public static Logger getInstance(String loggerName){
        instances.putIfAbsent(loggerName,new Logger());
        return instances.get(loggerName);
    }
    public void log(){
        //...
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
