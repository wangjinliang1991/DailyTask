package com.ai.doc.adaptor.v2;

import com.ai.doc.adaptor.ISensitiveWordsFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/16
 * @Version: 1.0
 **/
public class RiskManagement {
    private List<ISensitiveWordsFilter> filters = new ArrayList<>();
    public void addSensitiveWordsFilter(ISensitiveWordsFilter filter){
        filters.add(filter);
    }
    public String filterSensitiveWords(String text){
        String maskedText = text;
        for (ISensitiveWordsFilter filter: filters){
            maskedText = filter.filter(maskedText);
        }
        return maskedText;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
