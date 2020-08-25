package com.ai.doc.chain.sensitive;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class ApplicationDemo {
    public static void main(String[] args) {
        SensitiveWordFilterChain filterChain = new SensitiveWordFilterChain();
        filterChain.addFilter(new AdsWordFilter());
        filterChain.addFilter(new SexyWordFilter());
        filterChain.addFilter(new PoliticalWordFilter());
        
        boolean legal = filterChain.filter(new Content());
        if (!legal){
            //不发表
        }else {
            //发表
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
