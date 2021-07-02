package com.my.study.oop.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        //添加失败会返回false
        queue.offer(1);
        //queue.remove();异常
        queue.poll();
        //返回元素不删除元素
        //queue.element();异常
        queue.peek();
    }
}
