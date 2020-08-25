package com.ai.doc.singleton.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description: TODO
 * @Author:
 * @Date: 2020/8/10
 * @Version:
 **/
public enum IdGenerator {
    INSTANCE;
    private AtomicLong id = new AtomicLong(0);
    public long getId(){
        return id.incrementAndGet();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
