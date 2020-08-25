package com.ai.doc.chain.v3;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class HandlerChain {
    private List<IHandler> handlers = new ArrayList<>();
    public void addHandler(IHandler handler){
        this.handlers.add(handler);
    }
    public void handle(){
        for (IHandler handler:handlers){
            boolean handled = handler.handle();
            if (handled){
                break;
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
