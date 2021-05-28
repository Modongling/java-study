package com.my.study.stream;

import com.my.study.stream.entity.*;
import com.my.study.stream.entity.Currency;
import com.my.study.stream.collection.ToListCollector;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author mdl
 * @Created 2021/5/28 11:38
 * @Description
 */
public class StreamCollectionDemo {
    private static List<Transaction> transactions;
    private static  Map<String, List<String>> dishTags = new HashMap<>();
    static {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300, new Currency("RMB")),
                new Transaction(raoul, 2012, 1000, new Currency("RMB")),
                new Transaction(raoul, 2012, 400, new Currency("RMB")),
                new Transaction(mario, 2012, 710, new Currency("RMB")),
                new Transaction(mario, 2012, 900, new Currency("USD")),
                new Transaction(alan, 2012, 950, new Currency("USD"))
        );

        dishTags.put("pork", Arrays.asList("greasy", "salty"));
        dishTags.put("beef", Arrays.asList("salty", "roasted"));
        dishTags.put("chicken", Arrays.asList("fried", "crisp"));
        dishTags.put("french fries", Arrays.asList("greasy", "fried"));
        dishTags.put("rice", Arrays.asList("light", "natural"));
        dishTags.put("season fruit", Arrays.asList("fresh", "natural"));
        dishTags.put("pizza", Arrays.asList("tasty", "salty"));
        dishTags.put("prawns", Arrays.asList("tasty", "roasted"));
        dishTags.put("salmon", Arrays.asList("delicious", "fresh"));
    }

    public static void groupTransaction(List<Transaction> transactions) {
        Map<Currency, List<Transaction>> currencyTransactionMap = new HashMap<>();
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transCur = currencyTransactionMap.get(currency);
            if (transCur == null || transCur.size() == 0) {
                transCur = new ArrayList<>();
                currencyTransactionMap.put(currency, transCur);
            }
            transCur.add(transaction);
        }
    }

    /**
     * 规约汇总为一个值
     * 分组
     * 分区
     * groupBy()
     * @param transactions
     */
    public static void groupDemo(List<Transaction> transactions) {
        Map<Currency, List<Transaction>> currencyTransactionMap =
                transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency));
    }

    /**
     * 规约汇总
     * @param dishes
     */
    public static void countDemo(List<Dish> dishes) {
        //long countDish = dishes.stream().count();
        long countDish = dishes.stream().collect(Collectors.counting());
    }

    /**
     * 最值
     * @param dishes
     */
    public static void maxMinDemo(List<Dish> dishes) {
        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> max = dishes.stream().collect(Collectors.maxBy(dishComparator));
        Optional<Dish> min = dishes.stream().collect(Collectors.minBy(dishComparator));
    }

    /**
     * 汇总
     * @param dishes
     */
    public static void sumDemo(List<Dish> dishes) {
        //对象 --- 值 映射
        int total = dishes.stream().collect(Collectors.summingInt(Dish::getCalories));
        double avg = dishes.stream().collect(Collectors.averagingInt(Dish::getCalories));
        //所有汇总
        IntSummaryStatistics statistics = dishes.stream().collect(Collectors.summarizingInt(Dish::getCalories));
    }

    /**
     * 字符串连接
     * @param dishes
     */
    public static void strConcatDemo(List<Dish> dishes) {
        String joinCase = dishes.stream().map(Dish::getName).collect(Collectors.joining(", "));
    }

    public static void reduceDemo(List<Dish> dishes) {
      int total = dishes.stream().collect(Collectors.reducing(0,
                Dish::getCalories, (i, j) -> i + j));
       Optional<Dish> max = dishes.stream().collect(Collectors.reducing((d1, d2) ->
                d1.getCalories() > d2.getCalories() ? d1 : d2));

       dishes.stream().map(Dish::getName).collect(Collectors.reducing((s1, s2) -> s1 + s2)).get();
       dishes.stream().collect(Collectors.reducing("", Dish::getName, (s1, s2) -> s1 + s2));
    }

    public static void reduceCollectorDemo() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        List<Integer> nums = stream.reduce(new ArrayList<Integer>(), (List<Integer> l, Integer e) -> {
            l.add(e);
            return l;
        },
                (List<Integer> l2, List<Integer> l3) -> {
            l2.addAll(l3);
            return l2;
                });
    }

    /**
     * 流 --- 按键分组
     * @param dishes
     */
    public static void groupDemo2(List<Dish> dishes) {
        Map<String, List<Dish>> dishesByType = dishes.stream().collect(Collectors.groupingBy(Dish::getType));
    }

    /**
     * 返回某个key的映射
     * @param dishes
     */
    public static void groupDemo3(List<Dish> dishes) {
        Map<CaloricLevel, List<Dish>> caloricLevelListMap = dishes.stream().collect(Collectors.groupingBy(
                dish -> {
                    if (dish.getCalories() <= 400){
                        return CaloricLevel.DIET;
                    } else if (dish.getCalories() <= 700) {
                        return CaloricLevel.NORMAL;
                    } else {
                        return CaloricLevel.FAT;
                    }
                }
        ));
    }

    /**
     * Collectors.filtering()
     * Collectors.flatMapping()
     * @param dishes
     */
    public static void groupDemo4(List<Dish> dishes) {
//        分组过滤
//        Map<String, List<String>> dishesByType = dishes.stream().collect(Collectors.groupingBy(Dish::getType,
//                Collectors.filtering(dish -> dish.getCalories() > 500, Collectors.toList())));
        Map<String, List<String>> dishesByTypeName = dishes.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.mapping(Dish::getName, Collectors.toList())));
        //提取标签
//        Map<String, Set<String>> dishesByType = dishes.stream().collect(Collectors.groupingBy(Dish::getType,
//                Collectors.flatMapping(dish -> dishTags.get(dish.getName()).stream(), Collectors.toSet())));
    }

    public static void groupDemo5(List<Dish> dishes) {
        Map<String, Map<CaloricLevel, List<Dish>>> dishesMap =
                dishes.stream().collect(Collectors.groupingBy(Dish::getType,
                        Collectors.groupingBy(dish -> {
                            if (dish.getCalories() <= 400){
                                return CaloricLevel.DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else {
                                return CaloricLevel.FAT;
                            }
                        })));
    }

    public static void groupDemo6(List<Dish> dishes) {
        Map<String, Long> typeCount = dishes.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.counting()));
        Map<String, Optional<Dish>> typeMax = dishes.stream().collect(Collectors.groupingBy(Dish::getType,
                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
//        类型转换
//        Map<String, Dish> max = dishes.stream().collect(Collectors.groupingBy(Dish::getType,
//                Collections.collectingAndThen(
//                Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));
    }

    /**
     *分区分组
     *通过谓词筛选
     * @param dishes
     */
    public static void partitionGroup(List<Dish> dishes) {
        Map<Boolean, List<Dish>> parMap = dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        Map<Boolean, Map<String, List<Dish>>> parMap2 = dishes.stream().collect(Collectors.partitioningBy(Dish::isVegetarian,
                Collectors.groupingBy(Dish::getType)));
    }

    public static boolean isPrime(int candidate) {
        return IntStream.range(2, candidate)
                .noneMatch(i -> candidate % i == 0);
    }

    public static boolean isPrime2(int candidate) {
        int can = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, can)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(Collectors.partitioningBy(c -> isPrime2(c)));
    }

    /**
     * Collector<T, A, R>
     *     T:要收集的项目泛型
     *     A:累加器类型
     *     R:结果对象
     */

    public static List<Dish> myToList(List<Dish> dishes) {
        return dishes.stream()
                .collect(new ToListCollector<>());

        //不使用Collector
//        dishes.stream().collect(ArrayList::new,
//                List::add,
//                List::addAll);
    }

}
