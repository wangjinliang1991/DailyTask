package com.ai.doc.strategy.sort.v2;

import com.ai.doc.strategy.sort.v1.ConcurrentExternalSort;
import com.ai.doc.strategy.sort.v1.ExternalSort;
import com.ai.doc.strategy.sort.v1.ISortAlg;
import com.ai.doc.strategy.sort.v1.MapReduceSort;
import com.ai.doc.strategy.sort.v1.QuickSort;

import java.io.File;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/18
 * @Version: 1.0
 **/
public class Sorter {
    private static final long GB = 1000*1000*1000;
    public void sortFile(String filePath){
        //省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length();
        ISortAlg sortAlg;
        if (fileSize < 6*GB){
            sortAlg = SortAlgFactory.getSortAlg("QuickSort");
        }else if (fileSize < 10*GB){
            sortAlg = SortAlgFactory.getSortAlg("ExternalSort");
        }else if (fileSize < 100*GB){
            sortAlg = SortAlgFactory.getSortAlg("ConcurrentExternalSort");
        }else {
            sortAlg = SortAlgFactory.getSortAlg("MapReduceSort");
        }
        sortAlg.sort(filePath);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
