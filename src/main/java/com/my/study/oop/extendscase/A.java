package com.my.study.oop.extendscase;

public class A {
    public A() {
        System.out.println("调用A()");
    }
}

class B extends A {
    public B(String str) {
        System.out.println("构造器B(String)");
    }

    public B(String str, Integer i) {
        this(str);
        System.out.println("构造器B(String，Integer)");
    }
}

class C extends B {
    public C() {
        super("c", 3);
        System.out.println("C()");
    }

    /**
     * 初始化顺序 ---> 顶层父类构造器/次顶层父类构造器.../本类构造器
     * @param args
     */
    public static void main(String[] args) {
        new C();
    }
}
