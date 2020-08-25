package com.ai.doc.strategy.sort;

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
        
        if (fileSize < 6*GB){
            quickSort(filePath);
        }else if (fileSize < 10*GB){
            externalSort(filePath);
        }else if (fileSize < 100*GB){
            concurrentExternalSort(filePath);
        }else {
            mapreduceSort(filePath);
        }
    }

    private void mapreduceSort(String filePath) {
        //利用MapReduce排序
    }

    private void concurrentExternalSort(String filePath) {
        //多线程外排
    }

    private void externalSort(String filePath) {
        //外部排序
    }

    private void quickSort(String filePath) {
        //快排
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
