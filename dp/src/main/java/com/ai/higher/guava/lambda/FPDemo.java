package com.ai.higher.guava.lambda;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
public class FPDemo {
    public static void main(String[] args) {
        Optional<Integer> result = Stream.of("f","ba","hello")
                .map(s->s.length())
                .filter(l->l<=3)
                .max((o1,o2)->o1-o2);
        System.out.println(result.get());//输出2

    }
    
    
    
    
    
    
    
    
    
    
}
