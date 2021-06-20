package com.my.study.oop.innerclass;

public class AnonymousTest {
    public static void main(String[] args) {
        /**
         * new interface(){method(xxx){}};
         */
        TestInterface testInterface = new TestInterface() {
            @Override
            public void action() {
                System.out.println("Hello");
            }
        };
    }
}
