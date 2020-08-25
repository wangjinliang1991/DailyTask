package com.ai.doc.iterator.v2;

import com.ai.doc.iterator.v1.Iterator;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/19
 * @Version: 1.0
 **/
public class Demo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("xzg");
        names.add("b");
        names.add("c");

        Iterator<String> iterator = names.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
