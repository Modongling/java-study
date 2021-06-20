package com.my.study.oop.systems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerReadFileTest {
    public static void main(String[] args) throws FileNotFoundException {
        //接受一个文件
        Scanner in = new Scanner(new File("D:\\study-project\\java-study\\src\\main\\java\\com\\my\\study\\oop\\systems\\ScannerReadLineTest.java"));
        while (in.hasNextLine()) {
            System.out.println(in.nextLine());
        }
    }
}
