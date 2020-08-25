package com.ai.doc.strategy.v3;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/23
 * @Version: 1.0
 **/
public class Application {
    //运行时动态确定，根据配置文件的配置决定使用哪种策略
    public static void main(String[] args) throws Exception {
        EvictionStrategy evictionStrategy = null;
        Properties properties = new Properties();
        properties.load(new FileInputStream("./config.properties"));
        String type = properties.getProperty("eviction_type");
        evictionStrategy = EvictionStrategyFactory.getEvictionStrategy(type);
        UserCache userCache = new UserCache(evictionStrategy);
        //...
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
