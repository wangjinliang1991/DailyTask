package com.ai.doc.singleton.singleton04;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/10
 * @Version: 1.0
 **/
public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private IdGenerator(){}
    private static class SingletonHolder{
        private static final IdGenerator instance = new IdGenerator();
    }
    public static IdGenerator getInstance(){
        return SingletonHolder.instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
