package com.my.study.oop.file;

import java.io.File;

public class FileModifyTest2 {
    public static void main(String[] args) {
        File file = new File("d:\\aa\\bb");
        System.out.println(file.mkdir());
        System.out.println(file.mkdirs());
    }
}
