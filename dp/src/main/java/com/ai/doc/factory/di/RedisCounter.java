package com.ai.doc.factory.di;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/13
 * @Version: 1.0
 **/
public class RedisCounter {
    private String ipAddress;
    private int port;
    public RedisCounter(String ipAddress,int port){
        this.ipAddress = ipAddress;
        this.port = port;
    }
    //...
}
