package com.my.study.oop.innerclass;

public class UseTest {
    public static void main(String[] args) {
        /**
         * 非静态内部类
         * 先创建外部类对象
         * outer.new InnerClass()
         * 创建一个内部类对象
         * Outer.Inner var
         */
        NoneStaticClassTestOuter noneStaticClassTestOuter = new NoneStaticClassTestOuter();
        noneStaticClassTestOuter.getInfo();
        NoneStaticClassTestOuter.NoneStaticClassInner noneStaticClassInner = noneStaticClassTestOuter.new NoneStaticClassInner();
        noneStaticClassInner.innerMethod();

        /**
         * 静态内部类
         * Outer.Inner var
         * new Outer.Inner()
         */
        StaticClassOuter.StaticClassInner inner = new StaticClassOuter.StaticClassInner();
        inner.innerMethod();
    }
}
