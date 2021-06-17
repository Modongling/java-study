package com.my.study.oop.array;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class ArraysUtilsTest {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 3, 4, 5};
        Arrays.sort(a);
        //需要排序
        System.out.println("index:" + Arrays.binarySearch(a, 3));
        //返回最后一个查找到的位置
        System.out.println("index2:" + Arrays.binarySearch(a, 2, a.length, 3));
        int[] b = new int[8];
        //复制数组，如果新长度小于原数组则返回原数组，否者补充默认值
        Arrays.stream(Arrays.copyOf(a, b.length)).forEach(System.out::println);
        //返回指定返回的数组
        Arrays.stream(Arrays.copyOfRange(a,3, a.length)).forEach(System.out::println);
        int[] c = new int[3];
        //批量赋值
        Arrays.fill(c, 1);
        Arrays.stream(c).forEach(System.out::println);
        //赋值某个范围
        Arrays.fill(c, 1, c.length, 2);
        Arrays.stream(c).forEach(System.out::println);
        //指定范围的元素
        Arrays.sort(c, 0 ,1);
        /**
         * 底层toIndex都没有取等，所有可以是取到Array.length
         */

        int[] d = new int[]{5, 4, 2, 1, 3};
        //除第一个元素外的累加
        Arrays.parallelPrefix(d, Integer::sum);
        System.out.println(Arrays.toString(d));
        Arrays.parallelSort(d);
        //取得索引值
        Arrays.setAll(d, operand -> operand + 1);
        Arrays.parallelSetAll(d, IntUnaryOperator.identity());
        System.out.println(Arrays.toString(d));
    }
}
