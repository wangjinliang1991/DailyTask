package com.ai.doc.chain.sensitive.v1;

import com.ai.doc.chain.sensitive.Content;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/23
 * @Version: 1.0
 **/
public class SensitiveWordFilter {
    //return true if content doesn't contain sensitive words.
    public boolean filter(Content content){
        if (!filterSexyWord(content)){
            return false;
        }
        if (!filterAdsWord(content)){
            return false;
        }
        if (!filterPoliticalWord(content)){
            return false;
        }
        return true;
    }
    private boolean filterSexyWord(Content content){
        //...
    }
    private boolean filterAdsWord(Content content){
        //...
    }
    private boolean filterPoliticalWord(Content content){
        //...
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
