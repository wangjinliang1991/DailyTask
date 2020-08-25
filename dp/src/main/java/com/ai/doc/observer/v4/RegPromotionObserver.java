package com.ai.doc.observer.v4;

import com.ai.doc.observer.v2.PromotionService;
import com.google.common.eventbus.Subscribe;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class RegPromotionObserver {
    private PromotionService promotionService;
    
    @Subscribe
    public void handleRegSuccess(long userId){
        promotionService.issueNewUserExperienceCash(userId);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
