package com.ai.doc.bridge.v1;

import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/16
 * @Version: 1.0
 **/
public class Notification {
    private List<String> emailAddresses;
    private List<String> telephones;
    private List<String> wechatIds;
    
    public Notification(){}
    public void setEmailAddresses(List<String> emailAddresses){
        this.emailAddresses = emailAddresses;
    }
    public void setTelephones(List<String> telephones){
        this.telephones = telephones;
    }
    public void setWechatIds(List<String> wechatIds){
        this.wechatIds = wechatIds;
    }
    
    public void notify(NotificationEmergencyLevel level,String message){
        if (level.equals(NotificationEmergencyLevel.SERVER)){
            //...自动语音电话...
        }else if (level.equals(NotificationEmergencyLevel.UERGENCY)){
            // ... 发微信...
        }else if (level.equals(NotificationEmergencyLevel.NORMAL)){
            // ...发邮件...
        }else if (level.equals(NotificationEmergencyLevel.TRIVIAL)){
            // ...发邮件...
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
