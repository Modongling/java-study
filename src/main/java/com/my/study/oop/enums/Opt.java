package com.my.study.oop.enums;

public enum Opt {
    PLUS{
        @Override
        public double cal(double x, double y) {
            return x + y;
        }
    },
    SUB{
        @Override
        public double cal(double x, double y) {
            return x - y;
        }
    };

    public abstract double cal(double x, double y);

    public static void main(String[] args) {
        System.out.println(Opt.PLUS.cal(1, 1));
    }
}
