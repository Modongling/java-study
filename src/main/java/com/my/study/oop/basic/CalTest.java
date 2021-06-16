package com.my.study.oop.basic;

public class CalTest {
    public static void main(String[] args) {
        double a = 5.2D;
        double b = 3.1D;
        System.out.println(a % b);
        System.out.println(0 % 5);
        //NaN 除Integer异常
        System.out.println(5 % 0.0);

        //Math
        double c = 2;
        System.out.println(Math.pow(c, 3));
        System.out.println(Math.sqrt(16));
        System.out.println(Math.random());

        //位运算
        System.out.println(5 & 9);
        System.out.println(5 | 9);
        System.out.println(~5);
        System.out.println(5 ^ 9);

        //右移符号位填充 x / 2^n
        System.out.println(5 >> 2);
        //无符号右移0填充
        System.out.println(-5 >>> 2);
        //右移 x * 2^n
        System.out.println(5 << 2);

        byte bt = 5;
        //bt = bt + 5; 5为int
        //基本运算符扩展
        bt += 5;

        /**
         * 其他运算符
         * && || （短路） ! ^
         * 其他基本运算符
         */
        //三目运算
        String s = 2 > 1 ? "2" : "1";
    }
}
