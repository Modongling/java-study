package com.my.study.oop.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("elem");
        c.add("elem2");
        System.out.println(c.size());
        c.remove("elem");
        System.out.println(c.contains("elem2"));

        Collection c2 = new HashSet();
        c2.add("h1");
        c2.add("h2");
        c.add("elem2");
        //只保留某个集合元素
        c2.retainAll(c);

        Collection c3 = new ArrayList();
        c3.add("elem2");
        c3.add("elem2");

        System.out.println(c.containsAll(c3));

        c3.removeAll(c);
        c.clear();
    }
}
