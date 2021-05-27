package com.my.study.stream.paramaction;

import com.my.study.stream.paramaction.entity.Apple;
import com.my.study.stream.paramaction.entity.Color;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author mdl
 * @Created 2021/5/21 16:39
 * @Description
 */
public class JavaInnerDemo {

    public static void sortComparatorLambda() {
        List<Apple> inventory = Arrays.asList(new Apple(Color.RED.name(), 150), new Apple(Color.GREEN.name(), 120));
        inventory.sort(Comparator.comparing(Apple::getWeight));
        //逆序
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        //多级比较
        inventory.sort(Comparator.comparing(Apple::getWeight)
        .reversed()
        .thenComparing(Apple::getColor));

    }

    public static void threadLambda() {
        Thread t = new Thread(() -> {
            System.out.println("Hello world.");
        });
    }

    public static void threadPoolLambda() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> callReturn = (Future<String>) executorService.submit(() -> {
            Thread.currentThread().getName();
        });
    }

}
