package com.ai.doc.bridge.v1;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/16
 * @Version: 1.0
 **/
public class ErrorAlertHandler extends AlertHandler {
    public ErrorAlertHandler(AlertRule rule,Notification notification){
        super(rule,notification);
    }
    @Override
    public void check(ApiStatInfo apiStatInfo){
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi())){
            notification.notify(NotificationEmergencyLevel.SERVER,"...");
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
