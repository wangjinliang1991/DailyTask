package com.ai.array;

import org.omg.CORBA.Object;

import java.util.ArrayList;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/9/1
 * @Version: 1.0
 **/
public class GenericArray<T> {
    private T[] data;
    private int size;
    
    public GenericArray(int capacity){
        data = (T[])new Object[capacity];
        size = 0;
    }
    
    //无参构造，默认数组容量10
    public GenericArray(){
        this(10);
    }
    
    //获取数组容量
    public int getCapacity(){
        return data.length;
    }
    
    //获取当前元素个数
    public int count(){
        return size;
    }
    
    //判断数组是否为空
    public boolean isEmpty(){
        return size==0;
    }
    
    //修改index位置的元素
    public void set(int index,T e){
        checkIndex(index);
        data[index]=e;
    }
    
    //获取对应index位置的元素
    public T get(int index){
        checkIndex(index);
        return data[index];
    }
    
    //查看数组是否包含元素e
    public boolean contains(T e){
        for (int i=0; i<size;i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }
    
    //获取对应元素的下标，未找到，返回-1
    public int find(T e){
        for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    
    //在index位置插入元素e,时间复杂度O(m+n)
    public void add(int index,T e){
        checkIndex4Add(index);
        
        //如果当前元素个数等于数组容量，将数组扩容为原来的2倍
        if (size == data.length){
            resize(2*data.length);
        }
        
        for (int i=size; i>=index; i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }
    
    //向数组头插入元素
    public void addFirst(T e){
        add(0,e);
    }
    
    //向数组尾部插入元素
    public void addLast(T e){
        add(size,e);
    }
    
    //删除index位置的元素，并返回
    public T remove(int index){
        checkIndex(index);
        
        T ret = data[index];
        for (int i=index+1; i<size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        
        //缩容
        if (size==data.length/4 && data.length/2 !=0){
            resize(data.length/2);
        }
        
        return ret;
    }
    
    //删除第一个元素
    public T removeFirst(){
        return remove(0);
    }
    
    //删除末尾元素
    public T removeLast(){
        return remove(size);
    }
    
    //从数组中删除指定元素
    public void removeElement(T e){
        int index = find(e);
        if (index!=-1){
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size = %d, capacity=%d \n",size,data.length));
        sb.append('[');
        for (int i=0;i<size;i++){
            sb.append(data[i]);
            if (i != size-1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //扩容，时间复杂度为O(n)
    private void resize(int capacity){
        T[] newData = (T[])new Object[capacity];
        
        for (int i=0; i<size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }
    
    private void checkIndex4Add(int index){
        if (index<0 || index>size){
            throw new IllegalArgumentException("add failed! Require index>=0 and index<size");
        }
    }
    
    private void checkIndex(int index){
        if (index<0 || index>size){
            throw new IllegalArgumentException("find failed! require index>=0 and index < size");
        }
    }

    public static void main(String[] args) {
        GenericArray array = new GenericArray(5);
        array.toString();
        array.add(0,1);
        array.add(1,2);
        array.add(2,4);
        array.add(3,5);
        array.add(4,8);
        array.toString();
        array.remove(2);
        array.toString();
    }
}
