package com.ai.doc.strategy.order.v1;

import com.ai.doc.strategy.order.Order;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/23
 * @Version: 1.0
 **/
public interface DiscountStrategy {
    double calDiscount(Order order);
}
