package com.my.study.stream;

import com.my.study.stream.entity.Dish;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
     * 跳过元素
     * @param dishes
     * @return
     */
    public static List<Dish> skipDemo(List<Dish> dishes) {
        return dishes.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(Collectors.toList());
    }

    /**
     * obj -- name
     * @param dishes
     * @return
     */
    public static List<String> mapDemo(List<Dish> dishes) {
        return dishes.stream()
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    /**
     * flatMap 把每个元素都映射成一个流
     * @return
     */
    public static List<String> flatMapDemo() {
        String [] strs = {"Hello", "world"};
        return Arrays.stream(strs)
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<int[]> flatMapDemo2() {
        List<Integer> num1 = Arrays.asList(1, 2, 3);
        List<Integer> num2 = Arrays.asList(3, 4);
        return num1.stream()
                .flatMap(i -> num2.stream()
                .map(j -> new int[] {i , j}))
                .collect(Collectors.toList());
    }

    /**
     * 匹配
     * anyMatch()
     * allMatch()
     * noneMatch()
     * @param dishes
     * @return
     */
    public static boolean matchDemo(List<Dish> dishes) {
        return dishes.stream()
                .anyMatch(Dish::isVegetarian);
    }

    /**
     * findAny ---> Optional
     * @param dishes
     * @return
     */
    public static boolean findDemo(List<Dish> dishes) {
        return dishes.stream()
                .filter(Dish::isVegetarian)
                .findAny().isPresent();
    }

    /**
     * Optional值是否存在
     * @param dishes
     */
    public static void optionalDemo(List<Dish> dishes) {
        dishes.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(dish -> System.out.println(dish.getName()));
    }

    public static Integer findDemo2() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = nums.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
        return first.orElse(0);
    }

    /**
     * BinaryOperator<T>
     * BiFunction<T,T,T>
     * 归约 --- 将流归约成一个值
     */
    public Integer reduceDemo() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
       return nums.stream()
                .reduce(0, (a, b) -> a + b);
    }

    public static void reduceDemo2() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        int sum = nums.stream().reduce(0, Integer::sum);
        Optional<Integer> sumOpt = nums.stream().reduce(Integer::sum);
        Optional<Integer> max = nums.stream().reduce(Integer::max);
        Optional<Integer> min = nums.stream().reduce(Integer::min);
    }

    public static void reduceDemo3(List<Dish> dishes) {
        //dishes.stream().count();
        //统计某个物品
        int count = dishes.stream()
                .map(dish -> 1)
                .reduce(0, Integer::sum);
    }

    /**
     * Stream<Integer> --- int
     * @param dishes
     * @return
     */
    public static Integer basicTypeMapDemo(List<Dish> dishes) {
        return dishes.stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }

    /**
     * Int --- Stream<Integer>
     * @param dishes
     * @return
     */
    public static Stream<Integer> boxDemo(List<Dish> dishes) {
        return dishes.stream()
                //IntStream
                .mapToInt(Dish::getCalories)
                .boxed();
    }

    /**
     * Optional with type
     * @param dishes
     */
    public static void optionalTypeDemo(List<Dish> dishes) {
        OptionalInt max = dishes.stream()
                .mapToInt(Dish::getCalories)
                .max();
        int realMax = max.orElse(1);
    }

    /**
     * range()
     * rangeClosed()
     */
    public static void rangeDemo() {
        //[1,100]
        IntStream evenNums = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNums.count());
    }

    public static void triples() {
        Stream<int []> tripeStream = IntStream.rangeClosed(1, 100)
                .boxed()
                //100个流中取一个a
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                        .mapToObj(b ->
                                new int[] {a, b, (int)Math.sqrt(a * a + b * b)}));

        tripeStream.limit(3).forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

    /**
     * 创建流
     * Stream.ofNullable()
     */
    public static void buildStream() {
        Stream<String> stream = Stream.of("Hello", "world");
        stream.map(String::toUpperCase).forEach(System.out::println);
        String str = System.getProperty("home");
        Stream<String> sStr = str == null ? Stream.empty() : Stream.of(str);
        //数组
        int [] nums = {1, 2, 3};
        int sum = Arrays.stream(nums).sum();
        //文件
        long words = 0;
        try(Stream<String> lines = Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {
            words = lines.flatMap(line -> Arrays.stream(line.split("")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 无限流
     * 9
     * iterate（seed, condition, action）
     * takeWhile(condition)
     */
    public static void unlimitedStream() {
        Stream.iterate(0, n -> n + 2)
                //通过limit现在无限流
                .limit(10)
                .forEach(System.out::println);

        //斐波那契
        Stream.iterate(new int[] {0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));

        //generate
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }


}
