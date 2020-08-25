package com.ai.doc.bridge.v2;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/16
 * @Version: 1.0
 **/
public class ServereNotification extends Notification {
    public ServereNotification(MsgSender msgSender) {
        super(msgSender);
    }

    @Override
    public void notify(String message) {
        msgSender.send(message);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
