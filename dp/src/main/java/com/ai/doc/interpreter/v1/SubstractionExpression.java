package com.ai.doc.interpreter.v1;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class SubstractionExpression implements Expression {
    private Expression exp1;
    private Expression exp2;
    public SubstractionExpression(Expression exp1,Expression exp2){
        this.exp1 = exp1;
        this.exp2 = exp2;
    }
    @Override
    public long interpret() {
        return exp1.interpret()-exp2.interpret();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
