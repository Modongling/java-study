package com.my.study.oop.deeplearn;

public class StingDemo {
    public static void main(String[] args) {
        //constantDemo();
        initString();
    }

    /**
     * 存储方式
     */
    public static void constantDemo() {
        String a = "a";
        String b = "a";//只向方法区中的字符串常量池
        System.out.println(a == b);
        a = "A";// 开辟一个新的地址，不能修改原有字符串的地址（不管是重新赋值还是拼接结果一致）replace()方法也一致
        String c = b + "c";
        System.out.println(b);
        System.out.println(c);

        String d = b.replaceAll("a", "c");
        System.out.println(b);
        System.out.println(d);
    }

    /**
     * 初始化
     */
    public static void initString() {
        String s1 = "s";
        String s2 = new String("s"); //堆内存中变量位置指向常量池
        String s3 = new String("s");
        String s4 = s3.intern(); //强制从常量池赋值
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s4 == s3);
        System.out.println(s4 == s1);
    }
}
