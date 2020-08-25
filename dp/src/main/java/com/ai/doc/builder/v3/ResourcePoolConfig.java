package com.ai.doc.builder.v3;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/15
 * @Version: 1.0
 **/
public class ResourcePoolConfig {
    private String name;
    private int maxTotal ;
    private int maxIdle ;
    private int minIdle ;
    
    private ResourcePoolConfig(Builder builder){
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }
    
    //将Builder设计为ResourcePoolConfig的内部类，也可以将其设计为独立的非内部类ResourcePoolConfigBuilder
    public static class Builder{
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;
        
        public ResourcePoolConfig buid(){
            //校验逻辑放到这里，包括必填项校验、依赖关系校验、约束条件校验等
            if (StringUtils.isBlank(name)){
                throw new IllegalArgumentException("name should not be empty.");
            }
            if (maxIdle > maxTotal){
                throw new IllegalArgumentException("...");
            }
            if (minIdle > maxTotal || minIdle > maxIdle){
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig(this);
        }
        
        public Builder setName(String name){
            if (StringUtils.isBlank(name)){
                throw new IllegalArgumentException("name should not be empty.");
            }
            this.name = name;
            return this;
        }
        public Builder setMaxTotal(int maxTotal){
            if (maxTotal <= 0){
                throw new IllegalArgumentException("maxTotal should be positive.");
            }
            this.maxTotal = maxTotal;
            return this;
        }
        
        public Builder setMaxIdle(int maxIdle){
            if (maxIdle < 0){
                throw new IllegalArgumentException("maxIdle should not be negative.");
            }
            this.maxIdle = maxIdle;
            return this;
        }
        
        public Builder setMinIdle(int minIdle){
            if (minIdle < 0){
                throw new IllegalArgumentException("minIdle should not be negative.");
            }
            this.minIdle = minIdle;
            return this;
        }
    }
    
    //这段代码会抛异常IllegalArgumentException，因为min
    ResourcePoolConfig config = new ResourcePoolConfig.Builder()
            .setName("dbConnectionPool")
            .setMaxTotal(16)
            .setMaxIdle(10)
            .setMinIdle(12)
            .buid();
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
