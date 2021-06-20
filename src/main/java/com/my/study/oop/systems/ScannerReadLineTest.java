package com.my.study.oop.systems;

import java.util.Scanner;

public class ScannerReadLineTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        /**
         * 读取一行
         */
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }

        /**
         * hasNextLong()
         * in.nextLong
         * 其他类型
         */
    }
}
