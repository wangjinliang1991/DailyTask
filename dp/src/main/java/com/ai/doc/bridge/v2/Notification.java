package com.ai.doc.bridge.v2;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/16
 * @Version: 1.0
 **/
public abstract class Notification {
    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }
    
    public abstract void notify(String message);
    
    
    
    
    
    
    
    
    
    
    
    
    
}
