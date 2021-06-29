package com.my.study.oop.deeplearn;

public class StringBufferBuilderDemo {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("a");
        sb.setCharAt(0, 'A');
        System.out.println(sb);
        sb.append("a");
    }
}
