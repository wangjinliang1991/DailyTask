package com.ai.doc.observer.v3;

import com.ai.doc.observer.v2.PromotionService;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService;
    @Override
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
