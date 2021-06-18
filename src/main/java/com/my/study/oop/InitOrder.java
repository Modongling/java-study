package com.my.study.oop;

public class InitOrder {
    public static void main(String[] args) {
        //静态代码块 --- 普通代码块 --- 构造函数
        //new A();
        //父类静态代码块 --- 子类静态代码块 --- 父类代码块 --- 父类构造器 --- 子类代码块 --- 子类构造器
        new B();
    }
}
class A {
    {
        int a = 10;
        System.out.println("a被初始化:" + a);
    }

    static {
        System.out.println("静态代码块");
    }

    public A() {
        System.out.println("无参构造器");
    }
}

class B extends A {
    static {
        System.out.println("子类B的静态代码块");
    }

    {
        System.out.println("B代码块");
    }

    public B() {
        System.out.println("B构造器");
    }
}