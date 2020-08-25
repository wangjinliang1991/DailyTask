package com.ai.doc.singleton.xiancheng;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/11
 * @Version: 1.0
 **/
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static final ConcurrentHashMap<Long,IdGenerator> instances = new ConcurrentHashMap<>();
    private IdGenerator(){}
    public static IdGenerator getInstance(){
        Long currentThreadId = Thread.currentThread().getId();
        instances.putIfAbsent(currentThreadId,new IdGenerator());
        return instances.get(currentThreadId);
    }
    public long getId(){
        return id.incrementAndGet();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
