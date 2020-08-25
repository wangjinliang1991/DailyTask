package com.ai.doc.chain.sensitive;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class SensitiveWordFilterChain {
    private List<SensitiveWordFilter> filters = new ArrayList<>();
    public void addFilter(SensitiveWordFilter filter){
        this.filters.add(filter);
    }
    //return true if content doesn't contain sensitive words
    public boolean filter(Content content){
        for (SensitiveWordFilter filter:filters){
            if (!filter.doFilter(content)){
                return false;
            }
        }
        return true;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
