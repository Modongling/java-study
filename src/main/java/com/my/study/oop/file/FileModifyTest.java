package com.my.study.oop.file;

import java.io.File;
import java.io.IOException;

public class FileModifyTest {
    public static void main(String[] args) {
        File file = new File("a.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            file.delete();
        }

    }
}
