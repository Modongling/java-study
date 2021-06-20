package com.my.study.oop.strings;

import java.nio.charset.StandardCharsets;

public class StringCaseTest {
    public static void main(String[] args) {
        //String 不可变类
        String s = new String("a");
        System.out.println(s);
        byte[] bytes = {1, 2, 3};
        String bs = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(bs);
        String bs2 = new String(bytes, 0, 1);
        System.out.println(bs2);
        String bs3 = new String(bytes, 0, 1, StandardCharsets.UTF_8);
        System.out.println(bs3);
        char[] chars = {'a', 'b'};
        String cs = new String(chars, 0, chars.length);
        System.out.println(cs);

        //StringBuffer线程安全
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("a");
        //StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("b");
    }
}
