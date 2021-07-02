package com.my.study.oop.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        List<Object> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        doSometing(list1);
        //编译错误
        //doSometing(list2);
        doSometing2(list2);
    }

    /**
     * 尝试接收一个任意类型的参数
     * @param list
     */
    public static void doSometing(List<Object> list) {
    }

    /**
     *<?>通配符接受任意类型
     * @param list
     */
    public static void doSometing2(List<?> list) {

    }
}
