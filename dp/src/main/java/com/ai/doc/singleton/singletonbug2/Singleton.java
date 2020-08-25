package com.ai.doc.singleton.singletonbug2;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/10
 * @Version: 1.0
 **/
public class Singleton {
    private static Singleton instance = null;
    private final int paramA;
    private final int paramB;

    private Singleton(int paramA,int paramB){
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public synchronized Singleton getInstance(int paramA,int paramB){
        if (instance==null){
            instance = new Singleton(paramA,paramB);
        }
        return instance;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
