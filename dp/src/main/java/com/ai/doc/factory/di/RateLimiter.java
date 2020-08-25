package com.ai.doc.factory.di;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/13
 * @Version: 1.0
 **/
public class RateLimiter {
    private RedisCounter redisCounter;
    public RateLimiter(RedisCounter redisCounter){
        this.redisCounter = redisCounter;
    }
    public void test(){
        System.out.println("hello world");
    }
    //...
}
