package com.ai.doc.iterator.v3;

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
        names.add("a");
        names.add("wang");
        names.add("zheng");

        Iterator<String> iterator =names.iterator();
        iterator.next();
        names.remove("a");
        iterator.next();//抛出异常
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
