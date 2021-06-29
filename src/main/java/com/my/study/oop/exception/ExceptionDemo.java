package com.my.study.oop.exception;

import java.io.File;
import java.io.FileReader;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            File file = new File("/a");
            FileReader reader = new FileReader(file);
            //子类需要声明在父类的上面
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally 执行");
        }
    }
}
