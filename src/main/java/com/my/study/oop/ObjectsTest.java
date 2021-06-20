package com.my.study.oop;

import java.util.Objects;

public class ObjectsTest {
    private static ObjectsTest obj;

    public static void main(String[] args) {
        //Objects.equals();
        //Objects.nonNull();
        System.out.println(Objects.hashCode(obj));
        System.out.println(Objects.toString(obj));
        System.out.println(Objects.requireNonNull(obj));
    }
}
