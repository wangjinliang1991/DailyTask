package com.ai.doc.singleton.singletonbug3;

import com.ai.doc.singleton.singletonbug2.Config;

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
    
    private Singleton(){
        this.paramA = Config.PARAM_A;
        this.paramB = Config.PARAM_B;
    }

    public synchronized Singleton getInstance(){
        if (instance==null){
            instance = new Singleton();
        }
        return instance;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
