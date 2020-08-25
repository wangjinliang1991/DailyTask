package com.ai.higher.guava.immutable.v2;

import com.sun.xml.internal.ws.wsdl.writer.document.http.Address;

/**
 * @Description: 深度不变模式,依赖的Address也是只有getter没有setter
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
public class User {
    private String name;
    private int age;
    private Address address;

    public User(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
