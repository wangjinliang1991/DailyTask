package com.ai.doc.chain.v1;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public abstract class Handler {
    protected Handler successor = null;
    public void setSuccessor(Handler successor){
        this.successor = successor;
    }
    public abstract void handle();
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
