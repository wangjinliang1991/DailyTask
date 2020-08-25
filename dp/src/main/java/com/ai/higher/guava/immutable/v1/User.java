package com.ai.higher.guava.immutable.v1;

import com.sun.jndi.cosnaming.IiopUrl;

/**
 * @Description: 普通不变模式
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
public class User {
    private String name;
    private int age;
    private IiopUrl.Address address;

    public User(String name, int age, IiopUrl.Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    //只有getter没有setter方法
}
