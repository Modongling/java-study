package com.my.study.oop.systems;

public class MainTest {
    /**
     * main交互测试
     * @param args
     * Java SystemTest params
     * Javac xxx.java --- xxx.class
     * java xxx --- run
     */
    public static void main(String[] args) {
        System.out.println(args.length);
        for (String arg : args) {
            System.out.println(arg);
        }

    }
}
