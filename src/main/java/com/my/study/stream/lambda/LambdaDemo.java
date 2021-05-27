package com.my.study.stream.lambda;

/**
 * @author mdl
 * @Created 2021/5/21 17:31
 * @Description 参数列表 -> {}(lambda主体)
 */

import com.my.study.stream.paramaction.CommonParamToAction;
import com.my.study.stream.paramaction.entity.Apple;
import com.my.study.stream.paramaction.entity.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

/**
 * return 作为控制流程语句在lambda中生效去使用{}
 * 什么时候使用lambda:函数式接口，有且仅有一个抽象方法，可以包含默认方法
 * 通过参数名称消除同名接口lambda的二义性
 * 局部变量---栈
 * 实例变量---堆
 * 防止lambda线程访问变量时，变量被回收
 * 外部变量的更改可能会阻碍并行模式
 */
public class LambdaDemo {

    /**
     * 基础方法
     * @return
     * @throws IOException
     */
    public static String processFile() throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    /**
     * 执行一个处理行为
     * @param p
     * @return
     * @throws IOException
     */
    public static String processFile(BufferReaderProcessor p) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    /**
     * 接受一个参数返回Boolean
     * 1.先检查函数接口 2.判断类型和参数返回值 3.检查lambda表达式是否合法
     * @return
     */
    public static List<String> predicateDemo() {
        Predicate<String> stringPredicate = (String s) -> !s.isEmpty();
        List<String> strings = Arrays.asList("Hello", "", "world");
        return CommonParamToAction.filter(strings, stringPredicate);
    }

    /**
     * 谓词
     * @return
     */
    public static List<Apple> predicateDemo2() {
        List<Apple> inventory = Arrays.asList(new Apple(Color.RED.name(), 150), new Apple(Color.GREEN.name(), 120));
        Predicate<Apple> redPredicate = (Apple apple) -> Color.RED.name().equals(apple.getColor());
        //取非
        Predicate<Apple> notRedApple = redPredicate.negate();
        //and && or
        Predicate<Apple> redAndHeavy = redPredicate.and(apple -> apple.getWeight() >= 150)
                .or(apple -> Color.GREEN.name().equals(apple.getColor()));
        return CommonParamToAction.filter(inventory, redAndHeavy);
    }

    /**
     * 接受一个参数，返回void
     */
    public static void ConsumerDemo() {
        List<String> strings = Arrays.asList("Hello", "world");
        CommonParamToAction.myForEach(strings, System.out::println);
    }

    /**
     * 接受一个T类型参数，返回一个R类型参数
     * @return
     */
    public static List<Integer> functionDemo() {
        List<String> strings = Arrays.asList("Hello", "world");
        return CommonParamToAction.map(strings, String::length);
    }

    public static void intPredicate() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        //无装箱提升性能
        IntPredicate even = (int i) -> i % 2 == 0;
        System.out.println(even.test(nums.get(1)));
    }

    /**
     * Class::staticMethod
     * this::instanceMethod
     * Class:instanceMethod
     */
    public static void methodRef() {
        List<String> strings = Arrays.asList("a", "b", "A", "B");
        strings.sort(String::compareToIgnoreCase);
    }

    /**
     * supplier接口构造对象
     */
    public static void supplyDemo() {
        Supplier<Apple> appleSupplier = Apple::new;
        Apple apple = appleSupplier.get();
        BiFunction<String, Integer, Apple> appleWithArgs = Apple::new;
        Apple apple2 = appleWithArgs.apply(Color.GREEN.name(), 50);
    }

    /**
     * Map对象构造使用
     */
    public static void mapUse() {
        Map<String, BiFunction<String, Integer, Apple>> appleMap = new HashMap<>();
        appleMap.put("greenApple", Apple::new);
        appleMap.put("redApple", Apple::new);
       Apple apple = getApple("greenApple", "green", 100, appleMap);
    }

    private static Apple getApple(String appleName, String color, Integer weight, Map<String, BiFunction<String, Integer, Apple>> appleMap) {
        return appleMap.get(appleName)
                .apply(color, weight);
    }

    public static void functionDemo2() {
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        //g(f(x))
        Function<Integer, Integer> h = f.andThen(g);
        h.apply(1);
        //f(g(x))
        Function<Integer, Integer> i = f.compose(g);
        i.apply(1);
    }

    public static void functionDemo3() {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transformation = addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter);
    }


    private static class Letter {
        public static String addHeader(String text) {
            return "From xxx " + text;
        }

        public static String addFooter(String text) {
            return text + " Kind regards";
        }

        public static String checkSpelling(String text) {
            return text.replaceAll("labda", "lambda");
        }
    }

    public static void main(String[] args) throws IOException {
        /**
         * 参数 -> 行为
         */
        String line = processFile((BufferedReader br) -> br.readLine());
        System.out.println(line);
    }
}
