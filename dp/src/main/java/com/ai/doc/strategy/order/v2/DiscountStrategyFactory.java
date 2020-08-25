package com.ai.doc.strategy.order.v2;

import com.ai.doc.strategy.order.OrderType;
import com.ai.doc.strategy.order.v1.DiscountStrategy;
import com.ai.doc.strategy.order.v1.GrouponDiscountStrategy;
import com.ai.doc.strategy.order.v1.NormalDiscountStrategy;
import com.ai.doc.strategy.order.v1.PromotionDiscountStrategy;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/23
 * @Version: 1.0
 **/
public class DiscountStrategyFactory {
    public static DiscountStrategy getDiscountStrategy(OrderType type){
        if (type == null){
            throw new IllegalArgumentException("type should not be null");
        }
        if (type.equals(OrderType.NORMAL)){
            return new NormalDiscountStrategy();
        }else if (type.equals(OrderType.GROUPON)){
            return new GrouponDiscountStrategy();
        }else if (type.equals(OrderType.PROMOTION)){
            return new PromotionDiscountStrategy();
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
