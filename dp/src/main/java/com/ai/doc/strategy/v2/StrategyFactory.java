package com.ai.doc.strategy.v2;

import com.ai.doc.strategy.v1.ConcreteStrategyA;
import com.ai.doc.strategy.v1.ConcreteStrategyB;
import com.ai.doc.strategy.v1.Strategy;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/23
 * @Version: 1.0
 **/
public class StrategyFactory {
    public static Strategy getStrategy(String type){
        if (type == null || type.isEmpty()){
            throw new IllegalArgumentException("type should not be empty.");
        }
        if (type.equals("A")){
            return new ConcreteStrategyA();
        }else if (type.equals("B")){
            return new ConcreteStrategyB();
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
