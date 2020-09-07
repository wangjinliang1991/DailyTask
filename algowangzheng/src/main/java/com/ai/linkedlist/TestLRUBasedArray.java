package com.ai.linkedlist;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/9/1
 * @Version: 1.0
 **/
public class TestLRUBasedArray {
    public static void main(String[] args) {
        testDefaultConstructor();
        testSpecifiedConstructor(4);
    }
    
    private static void testWithException(){
        LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
        lru.offer(null);
    }
    
    public static void testDefaultConstructor(){
        System.out.println("======无参测试========");
        LRUBasedArray<Integer> lru = new LRUBasedArray<>();
        lru.offer(1);
        lru.offer(2);
        lru.offer(3);
        lru.offer(4);
        lru.offer(5);
        System.out.println(lru);
        lru.offer(6);
        lru.offer(7);
        lru.offer(8);
        lru.offer(9);
        System.out.println(lru);
    }
    
    public static void testSpecifiedConstructor(int capacity){
        System.out.println("=========有参测试=========");
        LRUBasedArray<Integer> lru = new LRUBasedArray<>(capacity);
        lru.offer(1);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
        lru.offer(3);
        System.out.println(lru);
        lru.offer(4);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
        lru.offer(4);
        System.out.println(lru);
        lru.offer(7);
        System.out.println(lru);
        lru.offer(1);
        System.out.println(lru);
        lru.offer(2);
        System.out.println(lru);
    }
}
