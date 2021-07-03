package com.my.study.oop.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {
        File file = new File("newHello.txt");
        //字符输入流读取
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            char[] buffer = new char[5];
            //每次读入的个数
            //fileReader.read(buffer);
            int len;
            while ((len = fileReader.read(buffer)) != -1) {
//                for (int i = 0; i < len; i++) {
//                    System.out.println(buffer[i]);
//                }
                String res = new String(buffer, 0, len);
                System.out.println(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
