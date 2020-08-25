package com.ai.doc.strategy.sort.v2;

import com.ai.doc.strategy.sort.v1.ConcurrentExternalSort;
import com.ai.doc.strategy.sort.v1.ExternalSort;
import com.ai.doc.strategy.sort.v1.ISortAlg;
import com.ai.doc.strategy.sort.v1.MapReduceSort;
import com.ai.doc.strategy.sort.v1.QuickSort;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class SortAlgFactory {
    private static final Map<String, ISortAlg> algs = new HashMap<>();
    static {
        algs.put("QuickSort",new QuickSort());
        algs.put("ExternalSort",new ExternalSort());
        algs.put("ConcurrentExternalSort",new ConcurrentExternalSort());
        algs.put("MapReduceSort",new MapReduceSort());
    }
    
    public static ISortAlg getSortAlg(String type){
        if (type == null || type.isEmpty()){
            throw new IllegalArgumentException("type should not be empty");
        }
        return algs.get(type);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
