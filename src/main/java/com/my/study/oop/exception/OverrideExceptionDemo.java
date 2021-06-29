package com.my.study.oop.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class OverrideExceptionDemo {
    public static void main(String[] args) {
        display(new Sub());
    }
    public static void display(Super s) {
        try {
            s.method();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Super {
   public void method() throws IOException {}
}

class Sub extends Super {
    /**
     * 子类异常不大于父类
     * @throws FileNotFoundException
     */
    @Override
    public void method() throws FileNotFoundException {
        FileReader reader = new FileReader(new File("/a"));
    }
}