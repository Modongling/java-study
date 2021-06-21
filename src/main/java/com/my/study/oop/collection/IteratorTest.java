package com.my.study.oop.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List顺序结构，逻辑有序，物理上不一定有序，可以重复的线性结构
 */
public class IteratorTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        Iterator iterator = list.iterator();
        iterator.forEachRemaining(e -> System.out.println(e));
    }
}
