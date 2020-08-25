package com.ai.doc.strategy.order.v1;

import com.ai.doc.strategy.order.Order;
import com.ai.doc.strategy.order.OrderType;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/23
 * @Version: 1.0
 **/
public class OrderService {
    public double discount(Order order){
        OrderType type = order.getType();
        DiscountStrategy discountStrategy = DiscountStrategyFactory.getDiscountStrategy(type);
        return discountStrategy.calDiscount(order);
    }
    
    
    
    
    
    
    
    
    
    
    
}
