package com.my.study.oop.serial;

import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args) {
        serialObj();
        unSerialObj();
    }

    private static void serialObj() {
        //序列化将对象保存到磁盘或者通过网络传输
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.data"));
            oos.writeObject("Hello");
            oos.flush();
            oos.writeObject(new Person("A", 22));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void unSerialObj() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.data"));
            Object o = ois.readObject();
            System.out.println((String) o);
            System.out.println(ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
