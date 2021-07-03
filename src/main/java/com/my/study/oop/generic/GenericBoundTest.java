package com.my.study.oop.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericBoundTest {
    /**
     * 上界匹配，表示泛型为某个类的子类或本身都可以
     * @param numbers
     * @return
     */
    public static double getAvg(List<? extends Number> numbers) {
        return numbers.stream().map(Number::doubleValue).reduce(Double::sum).orElse(0D) / numbers.size();
    }

    /**
     * 下界匹配，传入Integer或者对应的父类
     * @param nums
     * @return
     */
    public static void get(List<? super Integer> nums) {
        nums.forEach(System.out::println);
    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(5);
        System.out.println(getAvg(integers));
        get(integers);

        List<Double> doubles = new ArrayList<>();
        doubles.add(5.0);
        doubles.add(5.0);
        System.out.println(getAvg(doubles));
    }

}
