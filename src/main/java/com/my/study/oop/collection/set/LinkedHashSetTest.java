package com.my.study.oop.collection.set;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        //HashSet依靠链表维护次序,插入顺序和遍历顺序一致
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        System.out.println(linkedHashSet);
    }
}
