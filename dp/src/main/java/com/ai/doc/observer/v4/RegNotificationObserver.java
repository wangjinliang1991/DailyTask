package com.ai.doc.observer.v4;

import com.ai.doc.observer.v3.NotificationService;
import com.google.common.eventbus.Subscribe;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class RegNotificationObserver {
    private NotificationService notificationService;
    
    @Subscribe
    public void handleRegSuccess(long userId){
        notificationService.sendInboxMessage(userId,"...");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
