package com.my.study.oop.compare;

import java.util.Arrays;

public class CompareDemo {
    public static void main(String[] args) {
        String[] strings = new String[]{"Z", "A", "C", "V"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
    }
}
