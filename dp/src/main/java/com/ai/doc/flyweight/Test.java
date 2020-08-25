package com.ai.doc.flyweight;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/17
 * @Version: 1.0
 **/
public class Test {
    public static void main(String[] args) {
        Integer i1 = 56;
        Integer i2 = 56;
        Integer i3 = 129;
        Integer i4 = 129;
        System.out.println(i1==i2);
        System.out.println(i3==i4);
        
        String s1 = "aaa";
        String s2 = "aaa";
        String s3 = new String("aaa");
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
