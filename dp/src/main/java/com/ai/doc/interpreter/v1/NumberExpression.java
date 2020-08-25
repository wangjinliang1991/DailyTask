package com.ai.doc.interpreter.v1;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class NumberExpression implements Expression {
    private long number;
    public NumberExpression(long number){
        this.number = number;
    }
    public NumberExpression(String number){
        this.number = Long.parseLong(number);
    }
    @Override
    public long interpret() {
        return this.number;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
