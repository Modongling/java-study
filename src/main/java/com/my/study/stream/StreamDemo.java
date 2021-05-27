package com.my.study.stream;

import com.my.study.stream.entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mdl
 * @Created 2021/5/24 1:18
 * @Description 流
 * 元素序列
 * 数据源与元素序列一致
 * 数据处理
 * 流水线 --- 返回一个流
 * 内部迭代
 * 声明性
 * 可复合
 * 并行
 * 集合和流的区别：需要时才进行计算，集合会提前进行计算，流只能被消费一次
 * 外部迭代，显式取出每个元素进行处理
 */
public class StreamDemo {

    public static List<String> getHighCalories(List<Dish> dishes) {
        /**
         * [filter --- map --- limit](中间操作) --- collect（终端操作）
         */
        return dishes.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * 数据源，中间操作，终端操作
     */

    /**
     * 筛选
     */
    public static List<Dish> filterDemo(List<Dish> dishes) {
       return dishes.stream()
                .filter(Dish::isVegetarian)
                .collect(Collectors.toList());
    }

    /**
     * 去重
     */
    public static void distinctDemo() {
        List<Integer> nums = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        nums.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 切片
     * takeWhile --- 排好序的情况下只用遍历一部分元素
     * dropWhile --- 取对立面
     */

    /**
     * 截断流，取前三个
     * @param dishes
     * @return
     */
    public static List<Dish> limitDemo(List<Dish> dishes) {
        return dishes.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(Collectors.toList());
    }

    /**
     * 逃过元素
     * @param dishes
     * @return
     */
    public static List<Dish> skipDemo(List<Dish> dishes) {
        return dishes.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
    }
}
