package com.ai.doc.singleton.singletonbug;

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
    
    public static Singleton getInstance(){
        if (instance==null){
            throw new RuntimeException("Run init() first.");
        }
        return instance;
    }
    
    public synchronized static Singleton init(int paramA,int paramB){
        if (instance==null){
            throw new RuntimeException("Singleton has been created.");
        }
        instance = new Singleton(paramA,paramB);
        return instance;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
