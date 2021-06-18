package com.my.study.oop;

public class VarInitTest {
    public static void main(String[] args) {
        /**
         * 1.栈内存开辟一个引用执行堆内存的实例存储位置（对于成员变量来说）
         * 2.如果是static变量，直接在堆内存被所有Person对象共享
         * 3.成员变量初始化时会有默认值，局部变量不会进行初始化
         */
        Person p1 = new Person();
    }
}
