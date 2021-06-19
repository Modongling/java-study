package com.my.study.oop;

import java.util.Arrays;

public class FinalTest {
    public static void main(String[] args) {
        //final引用
        final int[] arr = {2, 3, 4, 1};
        System.out.println(Arrays.toString(arr));
        //排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //对元素赋值
        arr[arr.length - 1] = 5;
        System.out.println(Arrays.toString(arr));
        //改变引用位置错误
        //arr = null;
        String s1 = "ab";
        final String s2 = "a";
        final String s3 = "b";
        //字面量提前赋值，所以编译期能确定字符串常量池的位置
        String s4 = s2 + s3;
        System.out.println(s1 == s4);
    }
}
