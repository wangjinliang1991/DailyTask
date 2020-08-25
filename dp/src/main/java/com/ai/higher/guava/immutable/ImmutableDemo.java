package com.ai.higher.guava.immutable;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
public class ImmutableDemo {
    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("a");
        originalList.add("b");
        originalList.add("c");
        
        List<String> jdkUnmodifiableList = Collections.unmodifiableList(originalList);
        List<String> guavaImmutableList = ImmutableList.copyOf(originalList);
        
        originalList.add("d");
        print(originalList); //a b c d
        print(jdkUnmodifiableList);// a b c d
        print(guavaImmutableList);//a b c
    }
    private static void print(List<String> list){
        for (String s: list){
            System.out.println(s+" ");
        }
        System.out.println();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
