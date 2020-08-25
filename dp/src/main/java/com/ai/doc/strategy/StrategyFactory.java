package com.ai.doc.strategy;

import com.ai.doc.strategy.v1.ConcreteStrategyA;
import com.ai.doc.strategy.v1.ConcreteStrategyB;
import com.ai.doc.strategy.v1.Strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/23
 * @Version: 1.0
 **/
public class StrategyFactory {
    private static final Map<String, Strategy> strategies = new HashMap<>();
    static {
        strategies.put("A",new ConcreteStrategyA());
        strategies.put("B",new ConcreteStrategyB());
    }
    public static Strategy getStrategy(String type){
        if (type == null || type.isEmpty()){
            throw new IllegalArgumentException("type should not be empty");
        }
        return strategies.get(type);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
