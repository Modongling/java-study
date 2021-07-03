package com.my.study.oop.file;

import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        //表示文件或者目录
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.length());
        System.out.println(file.lastModified());
        File fileRename = new File("newHello.txt");
        //rename
        System.out.println(file.renameTo(fileRename));

        //状态判断
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());

        //获取文件目录
        File file2 = new File("D:\\java-study");
        String[] fleNames = file2.list();
        for (String name : fleNames) {
            System.out.println(name);
        }

        File[] files = file2.listFiles();
        for (File f : files) {
            System.out.println(f);
        }


    }
}
