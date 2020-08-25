package com.ai.doc.observer;

import com.ai.doc.observer.v2.PromotionService;
import com.ai.doc.observer.v3.RegObserver;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
public class RegPromotionObserver implements RegObserver {
    // 第一种实现方式，其他类代码不变，就没有再重复罗列
    private PromotionService promotionService;//依赖注入
    
    @Override
    public void handleRegSuccess(final long userId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                promotionService.issueNewUserExperienceCash(userId);
            }
        });
        thread.start();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
