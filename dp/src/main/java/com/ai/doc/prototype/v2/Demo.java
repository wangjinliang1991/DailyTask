package com.ai.doc.prototype.v2;

import com.ai.doc.prototype.v1.SearchWord;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/15
 * @Version: 1.0
 **/
public class Demo {
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
    public void refresh(){
        HashMap<String,SearchWord> newKeywords = new LinkedHashMap<>();
        //从数据库中取出所有的数据，放入newKeywords
        List<SearchWord> toBeUpdatedSearchWords = getSearchWords();
        for (SearchWord searchWord: toBeUpdatedSearchWords){
            newKeywords.put(searchWord.getKeyword(),searchWord);
        }
        currentKeywords = newKeywords;
    }

    private List<SearchWord> getSearchWords() {
        //TODO 从数据库总取出所有的数据
        return null;
    }


}
