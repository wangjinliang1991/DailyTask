package com.ai.doc.compose.v3;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public abstract class HumanResource {
    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public long getId(){
        return id;
    }
    public abstract double calculateSalary();
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
