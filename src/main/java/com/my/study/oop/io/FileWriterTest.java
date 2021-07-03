package com.my.study.oop.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        File file = new File("newHello.txt");
        //输出流写到文件
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
//            fileWriter = new FileWriter(file, true);
            //默认覆盖
            fileWriter.write("\n new line");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
