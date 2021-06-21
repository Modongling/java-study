package com.my.study.oop.collection;

import java.util.*;

public class ForEachTest {
    public static void main(String[] args) {
        Collection c = new HashSet();
        c.add("one");
        c.add("two");
        c.forEach(e -> System.out.println(e));

        //Iterator
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //获取迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if ("a".equals(s)){
                //删除元素时
                //iterator.next();
                iterator.remove();
            }
            System.out.println(s);
            //list.remove(s)
            //迭代器中不应该做集合删除操作
        }
        System.out.println(list.size());
    }
}
