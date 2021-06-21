package com.my.study.oop.collection.list;

import java.util.*;

public class ListTest {
    public static void main(String[] args) {
        //线程不安全
        List<String> list = new ArrayList<>();
        //Deque实现类
        LinkedList<String> list2 = new LinkedList<>();
        list.add("a");
        list.add("b");
        //固定长度的list
        List<String> list3 = Arrays.asList("aa", "bb");
        //list迭代器的反向迭代
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list2.add("aaa");
        list2.add("bbb");
        list2.add("ccc");
        //添加到队尾
        list2.offer("ddd");
        //栈顶
        list2.push("eee");
        //队头
        list2.offerFirst("fff");
        System.out.println(list2.peekFirst());
        System.out.println(list2.peekLast());
        //删除栈顶元素
        System.out.println(list2.pop());
        //删除最后一个元素
        System.out.println(list2.pollLast());

        //线程安全的集合
        //Stack
        Vector<String> vector = new Vector<>();
        vector.add("va");
        System.out.println(vector);
    }
}
