package com.ai.doc.prototype.v3;

import com.ai.doc.prototype.v1.SearchWord;

import java.util.HashMap;
import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/15
 * @Version: 1.0
 **/
public class Demo {
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
    private long lastUpdateTime = -1;
    public void refresh(){
        //原型模式就这么简单，拷贝已有对象的数据，更新少量差值
        HashMap<String,SearchWord> newKeywords = currentKeywords;
        
        //从数据库中取出更新时间>lastUpdateTime的数据，放入currentKeywords
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);
        long maxNewUpdatedTime = lastUpdateTime;
        for (SearchWord searchWord: toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }
            if (newKeywords.containsKey(searchWord.getKeyword())){
                SearchWord oldSearchWord = newKeywords.get(searchWord.getKeyword());
                oldSearchWord.setCount(searchWord.getCount());
                oldSearchWord.setLastUpdateTime(searchWord.getLastUpdateTime());
            }else{
                newKeywords.put(searchWord.getKeyword(),searchWord);
            }
        }
        lastUpdateTime = maxNewUpdatedTime;
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords(long lastUpdateTime){
        //TODO 从数据库取出更新时间>lastUpdateTime的数据
        return null;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
