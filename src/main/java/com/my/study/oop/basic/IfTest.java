package com.my.study.oop.basic;

public class IfTest {
    public static void main(String[] args) {
        int age = 20;
        if (age > 18) {
            System.out.println("adult");
        } else if (age > 13) {
            System.out.println("teen");
        } else {
            System.out.println("child");
        }
    }
}
