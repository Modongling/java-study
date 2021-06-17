package com.my.study.oop.basic;

public class SwitchTest {
    public static void main(String[] args) {
        char score = 'A';
        /**
         * byte short int char String enum
         */
        switch (score) {
            case 'A':
                System.out.println("A");
                break;
            case 'B':
                System.out.println("B");
                break;
            default:
                System.out.println("input error");
        }
    }
}
