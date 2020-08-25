package com.ai.higher.jdk;

/**
 * @Description: TODO
 * @Author: wangjl
 * @Date: 2020/8/20
 * @Version: 1.0
 **/
public class Student {
    String name;
    int age;
    float score;

    public Student(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
