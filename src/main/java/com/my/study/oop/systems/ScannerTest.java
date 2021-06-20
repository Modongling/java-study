package com.my.study.oop.systems;

import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        //从键盘获取输入
        Scanner in = new Scanner(System.in);
        //使用\n作为分隔符
        in.useDelimiter("\n");
        //输出不为null
        while (in.hasNext()) {
            System.out.println(in.next());
        }
    }
}
