package com.my.study.oop.collection.set;

import java.util.EnumSet;

/**
 * 枚举Set
 */
public class EnumSetTest {
    public static void main(String[] args) {
        EnumSet<Test> enumSet = EnumSet.allOf(Test.class);
        System.out.println(enumSet);
    }
}

enum Test{
    TEST1,TEST2;
}