package com.my.study.oop;

public class StaticTest {
    public void noStaticMethod() {
        System.out.println("no static");
    }

    public static void staticMethod() {
        System.out.println("static");
    }

    public static void main(String[] args) {
        //类方法
        staticMethod();
        StaticTest test = new StaticTest();
        //实例方法
        test.noStaticMethod();
    }

}
