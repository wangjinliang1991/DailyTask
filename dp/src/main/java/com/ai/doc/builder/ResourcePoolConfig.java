package com.ai.doc.builder;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/15
 * @Version: 1.0
 **/
public class ResourcePoolConfig {
    private static final int DEFAULT_MAX_TOTAL = 8;
    private static final int DEFAULT_MAX_IDLE = 8;
    private static final int DEFAULT_MIN_IDLE = 0;
    
    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDLE;
    
    public ResourcePoolConfig(String name,Integer maxIdle,Integer maxTotal,Integer minIdle){
        if (StringUtils.isBlank(name)){
            throw new IllegalArgumentException("name should not be empty.");
        }
        this.name = name;
        
        if (maxTotal != null){
            if (maxTotal <= 0){
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
        }

        if (maxIdle != null){
            if (maxIdle < 0){
                throw new IllegalArgumentException("maxIdle should not be negative.");
            }
            this.maxIdle = maxIdle;
        }

        if (minIdle != null){
            if (minIdle < 0){
                throw new IllegalArgumentException("minIdle should not be negative.");
            }
            this.minIdle = minIdle;
        }
    }
    //...省略getter方法...
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
