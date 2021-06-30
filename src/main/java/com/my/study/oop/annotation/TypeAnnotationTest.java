package com.my.study.oop.annotation;


import java.util.ArrayList;
import java.util.List;

public class TypeAnnotationTest<@TypeAnnotation T> {
    public static void main(String[] args) {
        List<@TypeAnnotation String> list = new ArrayList<>();
    }
}
