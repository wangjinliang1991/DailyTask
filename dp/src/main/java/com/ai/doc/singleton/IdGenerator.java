package com.ai.doc.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/10
 * @Version: 1.0
 **/
public class IdGenerator {
    //AtomicLong是一个java并发库提供的原子变量类型
    //将一些线程不安全需要加锁的复合操作封装为线程安全的原子操作，如下面的incrementAndGet()
    private AtomicLong id = new AtomicLong(0);
    private static final IdGenerator instance = new IdGenerator();
    
    private IdGenerator(){}
    public static IdGenerator getInstance(){
        return instance;
    }
    public long getId(){
        return id.incrementAndGet();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
