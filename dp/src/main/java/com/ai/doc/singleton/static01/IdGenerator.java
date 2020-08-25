package com.ai.doc.singleton.static01;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description: 静态方法
 * @Author: wangjl
 * @Date: 2020/8/11
 * @Version: 1.0
 **/
public class IdGenerator {
    private static AtomicLong id = new AtomicLong(0);
    public static long getId(){
        return id.incrementAndGet();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
