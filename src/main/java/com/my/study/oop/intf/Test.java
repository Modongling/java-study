package com.my.study.oop.intf;

public interface Test {
    int CONTACT = 10;
    void action();
    default void test() {
        System.out.println("test default");
    }
    default String test2() {
        return "带返回值的默认方法";
    }

    static void test3() {
        System.out.println("静态默认方法");
    }
}
