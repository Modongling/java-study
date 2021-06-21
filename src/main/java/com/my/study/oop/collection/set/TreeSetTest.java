package com.my.study.oop.collection.set;

import java.util.TreeSet;

/**
 * SortedSet接口实现类
 */
public class TreeSetTest {
    public static void main(String[] args) {
        //排序的一个Set
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(10);
        treeSet.add(-9);
        System.out.println(treeSet);
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        //小于4的子集
        System.out.println(treeSet.headSet(4));
        System.out.println(treeSet.subSet(-3, 4));
    }
}
