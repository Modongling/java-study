package com.my.study.firstcase;

public class DataTypeDemo {
    //定义常量
    private final static int NUM_CONSTANT = 10;
    public static void main(String[] args) {
        /**
         * 整型
         * int,short,long,byte(-128~127)
         */
        int i = 20;
        long l = 20L;

        /**
         * 浮点型
         * float double
         */
        float f = 1.2F;//6-7有效位数
        double d = 1.2F;//15位
        /**
         * 浮点数定义
         */
        System.out.println(Double.POSITIVE_INFINITY);
        System.out.println(Double.NEGATIVE_INFINITY);
        double d2 = 0 / 0D;
        if (Double.isNaN(d2)) {
            System.out.println("d2不是数字");
        }

        /**
         * 字符型
         * char
         */
        char ch = 'a';
        char ch2 = '\\';
        System.out.println(ch == 97);
        System.out.println(ch2);

        /**
         * 布尔型
         */
        boolean b1 = true;
        boolean b2 = false;

        System.out.println(NUM_CONSTANT + 10);

    }
}
