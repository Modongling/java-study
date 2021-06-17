package com.my.study.oop.basic;

public class WhileTest {
    public static void main(String[] args) {
        int count = 0;
        while (count < 5) {
            System.out.println(count);
            count++;
        }
        System.out.println("end");

        //至少执行一次
        do {
            System.out.println(count);
        } while (count < 10);
        System.out.println("over");
    }
}
