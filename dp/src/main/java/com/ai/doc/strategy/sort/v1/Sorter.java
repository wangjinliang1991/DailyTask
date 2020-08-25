package com.ai.doc.strategy.sort.v1;

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
            sortAlg = new QuickSort();
        }else if (fileSize < 10*GB){
            sortAlg = new ExternalSort();
        }else if (fileSize < 100*GB){
            sortAlg = new ConcurrentExternalSort();
        }else {
            sortAlg = new MapReduceSort();
        }
        sortAlg.sort(filePath);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
