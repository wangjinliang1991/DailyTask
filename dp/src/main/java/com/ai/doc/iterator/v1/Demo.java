package com.ai.doc.iterator.v1;

import java.util.ArrayList;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("xzg");
        names.add("wang");
        names.add("zheng");
        
        Iterator<String> iterator = new ArrayIterator<>(names);
        while(iterator.hasNext()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
