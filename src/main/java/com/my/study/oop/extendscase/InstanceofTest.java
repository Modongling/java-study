package com.my.study.oop.extendscase;

public class InstanceofTest {
    public static void main(String[] args) {
        Object o = "Hello";
        //判断对象是否是后面的类或者子类
        System.out.println(o instanceof Object);
        System.out.println(o instanceof String);
    }
}
