package com.my.study.oop.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ThrowsDemo {
    public static void main(String[] args) {
        try {
            throwsTest();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * 抛出异常交给调用方处理
     * @throws FileNotFoundException
     */
    public static void throwsTest() throws FileNotFoundException {
        File file = new File("/a");
        FileReader reader = new FileReader(file);
    }
}
