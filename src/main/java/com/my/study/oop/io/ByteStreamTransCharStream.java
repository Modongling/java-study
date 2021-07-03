package com.my.study.oop.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ByteStreamTransCharStream {
    public static void main(String[] args) {
        /**
         * 解码：字节 --> 字符
         * 编码: 字符 --> 字节
         */
        FileInputStream inputStream = null;
        InputStreamReader reader = null;
        try {
            inputStream = new FileInputStream("newHello.txt");
            reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            char[] buff = new char[10];
            int len;
            while ((len = reader.read(buff)) != -1) {
                String res = new String(buff, 0, len);
                System.out.println(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            writer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写字节流转字符流
     */
    public static void writer() throws IOException {
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        InputStreamReader reader = null;
        OutputStreamWriter writer = null;
        try {
            inputStream = new FileInputStream("newHello.txt");
            outputStream = new FileOutputStream("newHello_GBK.txt");
            reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            writer = new OutputStreamWriter(outputStream, "GBK");
            char[] buff = new char[10];
            int len;
            while ((len = reader.read(buff)) != -1) {
                writer.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
            }

            if (reader != null) {
                reader.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }
        }

    }
}

