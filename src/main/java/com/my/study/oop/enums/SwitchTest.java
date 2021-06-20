package com.my.study.oop.enums;

public class SwitchTest {
    public static void jude(EnumTest test) {
        switch (test) {
            case SPRING:
                System.out.println("spring");
                break;
            case SUMMER:
                System.out.println("summer");
                break;
            case FALL:
                System.out.println("fall");
                break;
            case WINTER:
                System.out.println("winter");
                break;
            default:
                System.out.println("error");
        }
    }

    public static void main(String[] args) {
        jude(EnumTest.SUMMER);

        //遍历枚举
        for (EnumTest test : EnumTest.values()) {
            System.out.println(test);
        }
        //比较枚举的顺序在所比较枚举之前返回负数，相同返回0,之后返回正数
        System.out.println(EnumTest.SUMMER.compareTo(EnumTest.SPRING));
        //返回名称可以用toString()代替
        System.out.println(EnumTest.SUMMER.name());
        //返回枚举索引值（枚举索引从0开始）
        System.out.println(EnumTest.SPRING.ordinal());
    }
}
