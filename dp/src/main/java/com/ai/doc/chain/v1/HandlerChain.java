package com.ai.doc.chain.v1;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class HandlerChain {
    private Handler head = null;
    private Handler tail = null;
    public void addHandler(Handler handler){
        handler.setSuccessor(null);
        
        if (head == null){
            head = handler;
            tail = handler;
            return;
        }
        
        tail.setSuccessor(handler);
        tail = handler;
    }
    public void handle(){
        if (head != null){
            head.handle();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
