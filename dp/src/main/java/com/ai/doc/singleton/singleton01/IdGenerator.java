package com.ai.doc.singleton.singleton01;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Description: 饿汉式
 * @Author: wangjl
 * @Date: 2020/8/10
 * @Version: 1.0
 **/
public class IdGenerator {
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
