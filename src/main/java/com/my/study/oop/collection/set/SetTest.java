package com.my.study.oop.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Set去重的集合
 * 是否是相同对象判断的是对象的值和hashcode
 * 通过hashcode定位元素存储位置，如果元素不同但hashcode相同
 * 有可能存储的位置相同，但是HashSet不支持这种结构会性能下降
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("a");
        set.add("b");
        set.forEach(e -> System.out.println(e));
    }
}
