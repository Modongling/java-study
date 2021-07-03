package com.my.study.oop.io;

import java.io.*;

public class SimpleFileCopy {
    public static void main(String[] args) {
        FileReader reader = null;
        FileWriter writer = null;
        try {
            reader = new FileReader("newHello.txt");
            File copy = new File("copy.txt");
            if (!copy.exists()) {
                copy.createNewFile();
            }
            writer = new FileWriter("copy.txt");

            char[] buffer = new char[5];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
