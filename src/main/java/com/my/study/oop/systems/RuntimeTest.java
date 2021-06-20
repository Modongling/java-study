package com.my.study.oop.systems;

import java.io.IOException;

public class RuntimeTest {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        //cpu合数
        System.out.println(runtime.availableProcessors());
        //空闲内存
        System.out.println(runtime.freeMemory());
        //最大内存
        System.out.println(runtime.maxMemory());
        //总内存
        System.out.println(runtime.totalMemory());
        //执行一个应用程序
        //runtime.exec("xxx");
    }
}
