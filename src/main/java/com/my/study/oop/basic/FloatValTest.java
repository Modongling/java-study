package com.my.study.oop.basic;

public class FloatValTest {
    public static void main(String[] args) {
        float a = 3.1415F;
        double b = 0.0D;
        //无穷大
        double c = Double.NEGATIVE_INFINITY;
        double d = Double.POSITIVE_INFINITY;
        //NaN
        System.out.println(b / b);
        //异常
        //System.out.println(0 / 0);
        double e = 100_000D;
    }
}
