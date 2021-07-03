package com.my.study.oop.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IOTest {
    public static void main(String[] args) {
        File file = new File("newHello.txt");
        //字符输入流读取
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            int data = fileReader.read();
            while (data != -1) {
                System.out.println((char)data);
                data = fileReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
