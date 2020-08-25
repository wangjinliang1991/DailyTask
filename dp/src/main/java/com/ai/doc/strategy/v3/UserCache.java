package com.ai.doc.strategy.v3;

import com.ai.doc.template.jdbc.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/23
 * @Version: 1.0
 **/
public class UserCache {
    private Map<String, User> cacheData = new HashMap<>();
    private EvictionStrategy eviction;
    public UserCache(EvictionStrategy eviction){
        this.eviction = eviction;
    }
    //...
    
    
    
    
    
    
    
    
    
    
    
    
}
