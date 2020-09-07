package com.ai.array;

/**
 * @Description: 数组的插入、删除、按照下标随机访问操作；数组的数据为int类型
 * @Author: wangjl
 * @Date: 2020/8/31
 * @Version: 1.0
 **/
public class Array {
    //定义整型数据data保存数据
    public int data[];
    //定义数组长度
    private int n;
    //定义数组中实际的元素个数
    private int count;
    
    //构造方法，定义数组大小
    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;//最开始个数为0
    }
    
    //根据索引查找数组中的元素并返回
    public int find(int index){
        if (index<0 || index>=count){
            return -1;
        }
        return data[index];
    }
    
    //插入元素：头部插入，尾部插入
    public boolean insert(int index,int value){
        //数组空间已满
        if (count == n){
            System.out.println("空间已满，没有可插入的位置");
            return false;
        }
        
        // 没有满，可插入
        // 位置不合法
        if (index < 0 || index > count){
            System.out.println("插入位置不合法");
            return false;
        }
        
        for (int i=count; i>index; i--){
            data[i] = data[i-1];
        }
        data[index] = value;
        count++;
        return true;
    }
    
    //根据索引，删除数组中的元素
    public boolean delete(int index){
        //位置不合法
        if (index < 0 || index >= count){
            return false;
        }
        
        for (int i=index + 1; i < count;i++){
            data[i-1] = data[i];
        }
        count--;
        return true;
    }
    
    public void printAll(){
        for (int i=0; i< count; i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0,3);
        array.insert(1,4);
        array.insert(2,2);
        array.insert(3,6);
        array.insert(4,1);
        array.printAll();
        array.insert(5,0);
        array.printAll();
        array.delete(2);
        array.printAll();
    }
}
