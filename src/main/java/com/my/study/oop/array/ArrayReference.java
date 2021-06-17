package com.my.study.oop.array;

public class ArrayReference {
    public static void main(String[] args) {
        int [] a = {1, 2, 3};
        //垃圾回收对象
        int [] b = new int[4];
        //b的引用指向a
        b = a;
        System.out.println("b:" + b.length);
    }
}
