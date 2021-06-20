package com.my.study.oop.innerclass;

/**
 * OuterClass$NInnerClass
 */
public class LocalInnerClassTest {
    public static void main(String[] args) {
        class InnerBase {
            int a;
        }
        class InnerSub extends InnerBase {
            int b;
        }
        InnerSub is = new InnerSub();
        is.a = 1;
        is.b = 2;
        System.out.println(is.a + " " + is.b);
    }
}
