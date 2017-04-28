package com.example;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Created by Guo on 2017/4/23.
 */
@Component
public class Student {
    private String name;
    @PreDestroy
    public void init() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
        System.out.println("初始化");
    }

    public void study() {
        System.out.println("学习");
    }
}