package com.my.study.oop.extendscase;

public class SubClass extends SuperClass {
    String i = "s";



    @Override
    public void method() {
        System.out.println("sub");
    }

    public void sm() {
        System.out.println("sub m");
    }

    public static void main(String[] args) {
        //父类
        SuperClass superClass = new SuperClass();
        System.out.println(superClass.i);
        superClass.method();
        superClass.m2();

        //子类
        SubClass subClass = new SubClass();
        System.out.println(subClass.i);
        subClass.method();
        subClass.sm();

        //多态:编译时是父类，运行时是子类的实现
        SuperClass sb = new SubClass();
        //多态发生时同名变量访问指向父类
        System.out.println(sb.i);
        //调用重写方法
        sb.method();
        sb.m2();
    }
}

class SuperClass {
    int i = 1;


    public void method() {
        System.out.println("super");
    }

    public void m2() {
        System.out.println("m2");
    }
}