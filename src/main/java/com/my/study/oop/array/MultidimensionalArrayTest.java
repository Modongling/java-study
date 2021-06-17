package com.my.study.oop.array;

public class MultidimensionalArrayTest {
    public static void main(String[] args) {
        //多维数组实际只需要初始化第一行
        //每一列是一个一维数组引用
        int[][] a = new int[3][];
        for (int i = 0; i < a.length ; i++) {
            System.out.println(a[i]);
        }
        a[0] = new int[2];
        a[0][1] = 2;
        for (int i = 0; i < a[0].length; i++) {
            System.out.println(a[0][i]);
        }
    }
}
