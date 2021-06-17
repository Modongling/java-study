package com.my.study.oop.array.exec;

import java.util.Arrays;

public class NumToString {
    private static String[] numStr = {"零", "壹", "贰"};

    public static String[] div(double num) {
        long l = (long) num;
        long f = Math.round((num - l) * 100);
        return new String[]{l + "", String.valueOf(f)};
    }

    public static String numToStr(String num) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - 48;
            res.append(numStr[n]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(div(1.25)));
        System.out.println(numToStr("201"));
    }
}
