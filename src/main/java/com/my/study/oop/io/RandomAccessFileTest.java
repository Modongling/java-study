package com.my.study.oop.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
    public static void main(String[] args) {
        RandomAccessFile accessFile = null;
        RandomAccessFile writerFile = null;
        try {
            /**
             * r
             * rw
             */
            accessFile = new RandomAccessFile(new File("test.png"), "r");
            writerFile = new RandomAccessFile(new File("test-copy.png"), "rw");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = accessFile.read(buffer)) != -1) {
                writerFile.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writerFile != null) {
                try {
                    writerFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (accessFile != null) {
                try {
                    accessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
