package com.ai.doc.interpreter.alert.v1;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class AlertRuleInterpreter {
    private Expression expression;
    public AlertRuleInterpreter(String ruleExpression){
        this.expression = new OrExpression(ruleExpression);
    }
    public boolean interpret(Map<String,Long> stats){
        return expression.interpret(stats);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
