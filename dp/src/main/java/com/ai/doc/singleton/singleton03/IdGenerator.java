package com.ai.doc.singleton.singleton03;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description: 双检锁
 * @Author: wangjl
 * @Date: 2020/8/10
 * @Version: 1.0
 **/
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator instance;
    private IdGenerator(){}
    public static synchronized IdGenerator getInstance(){
        if (instance == null){
            synchronized (IdGenerator.class){
                if (instance == null){
                    instance = new IdGenerator();
                }
            }
        }
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
