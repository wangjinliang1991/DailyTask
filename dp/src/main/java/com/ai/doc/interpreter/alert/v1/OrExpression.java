package com.ai.doc.interpreter.alert.v1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class OrExpression implements Expression {
    private List<Expression> expressions = new ArrayList<>();
    public OrExpression(String strOrExpression){
        String[] orExpressions = strOrExpression.split("\\|\\|");
        for (String orExpr : orExpressions){
            expressions.add(new OrExpression(orExpr));
        }
    }
    
    public OrExpression(List<Expression> expressions){
        this.expressions.addAll(expressions);
    }
    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expr:expressions){
            if (expr.interpret(stats)){
                return true;
            }
        }
        return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
