package com.ai.doc.chain.v1;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class HandlerA extends Handler {
    @Override
    public void handle() {
        boolean handled = false;
        //...
        if (!handled && successor != null){
            successor.handle();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
