package com.my.study.stream.paramaction;

import com.my.study.stream.paramaction.entity.Apple;
import com.my.study.stream.paramaction.entity.Color;
import com.my.study.stream.paramaction.predicate.ApplePredicate;
import com.my.study.stream.paramaction.prettyprint.FormatApple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author mdl
 * @Created 2021/5/18 14:14
 * @Description 行为化参数，将函数作为参数传递
 */
public class ParamToAction {

    /**
     * 将策略实现传递给代码
     * @param inventory
     * @param predicate
     * @return
     */
    public static List<Apple> filterApple(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void prettyPrintApple(List<Apple> inventory, FormatApple formatApple) {
        for (Apple apple : inventory) {
            String output = formatApple.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(Color.RED.name(), 150), new Apple(Color.GREEN.name(), 120));
        /**
         * 匿名内部类减少策略实现
         */
        List<Apple> result = filterApple(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Objects.equals(Color.RED.name(), apple.getColor());
            }
        });
        System.out.println(result);

        List<Apple> lResult = filterApple(inventory, (Apple apple) -> Color.RED.name().equals(apple.getColor()));
        System.out.println(lResult);
    }

}
