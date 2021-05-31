package com.my.study.collection;

import com.my.study.stream.entity.Currency;
import com.my.study.stream.entity.Transaction;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author mdl
 * @Created 2021/5/31 13:39
 * @Description
 */
public class CollectionDemo {
    /**
     * 创建集合对象
     */
    public static void asCollectionDemo() {
        //asList创建集合不可变
        List<String> words = Arrays.asList("hello", "world");
        //可变set,有多余对象分配
        Set<String> stringSet = new HashSet<>(Arrays.asList("Hello", "world"));
        Set<String> set = Stream.of("a", "b").collect(Collectors.toSet());
    }

    /**
     * 工厂方法合集
     */
    public static void listFactory() {
        //不可变
        //List<String> list = List.of("a", "b");
    }

    public static void setFactory() {
        //Set<String> set = Set.of("a", "b");
    }

    public static void mapFactory() {
        //Map<String, String> map = Map.of("k1", "v1", "k2", "v2");
        //Map<String, Integer> map = Map.ofEntries(Map.entry("k1", 2));
    }

    /**
     * 移除元素
     * @param transactions
     */
    public static void removeDemo(List<Transaction> transactions) {
        for (Iterator<Transaction> iterator = transactions.iterator(); iterator.hasNext();) {
            Transaction transaction = iterator.next();
            if (Character.isDigit(transaction.getCurrency().getType().charAt(0))) {
                iterator.remove();
            }
        }
        //移除元素
        transactions.removeIf(transaction -> Character.isDigit(transaction.getCurrency().getType().charAt(0)));
    }

    /**
     * 替换元素
     * @param transactions
     */
    public static void replaceAllDemo(List<Transaction> transactions) {
        transactions.stream()
                .map(type -> Character.toUpperCase(type.getCurrency().getType().charAt(0)) + type.getCurrency()
                .getType().substring(1))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        for (ListIterator<Transaction> iterator = transactions.listIterator(); iterator.hasNext();) {
            Transaction transaction = iterator.next();
            Transaction newTrans = transaction;
            String type = Character.toUpperCase(transaction.getCurrency().getType().charAt(0)) +
            transaction.getCurrency().getType().substring(1);
            Currency currency = new Currency(type);
            newTrans.setCurrency(currency);
            iterator.set(newTrans);
        }

        transactions.replaceAll(transaction -> new Transaction(null, 0, 0, null));
    }

    /**
     * map操作
     * @param map
     */
    public static void mapDemo(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
        }

        map.forEach((key, val) -> {
            System.out.println(key + " " + val);
        });

        //getOrDefault,如果不存在返回默认值
        System.out.println(map.getOrDefault("a", 0));

        //计算模式
        //computeIfAbsent
        Map<String, byte[]> data = new HashMap<>();
        data.keySet().forEach(key -> data.computeIfAbsent(key, CollectionDemo::calDigest));

    }

    private static byte[] calDigest(String key) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return messageDigest.digest(key.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * map排序
     * @param map
     */
    public static void sortDemo(Map<String, String> map) {
        //key排序
        //Map.Entry.comparingByValue()
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEachOrdered(System.out::println);

    }

    /**
     * 计算例子
     * 默认方法
     * @param map
     */
    public static void mapCase(Map<String, List<String>> map) {
        List<String> list = map.get("a");
        if (list == null || list.size() == 0) {
            list = new ArrayList<>();
            map.put("a", list);
        }
        list.add("AA");
        System.out.println(map);

        map.computeIfAbsent("a", name -> new ArrayList<>()).add("AA");
        //computeIfPresent()
        //compute()
    }

    /**
     * 删除模式
     * @param map
     */
    public static void mapDelete(Map<String, String> map) {
        map.remove("a", "AA");
        map.entrySet().removeIf(entry -> entry.getValue().equals("a"));
    }

    /**
     * 替换模式
     */
    public static void replaceMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "aa");
        map.put("b", "bb");
        map.replaceAll((key, val) -> val.toUpperCase());
        System.out.println(map);
    }

    /**
     * 合并映射
     */
    public static void mergeMap() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("a", "aa");
        Map<String, String> map2 = new HashMap<>();
        //存在重复键值的merge
        map2.put("a", "aa");
        map2.put("b", "bb");
        Map<String, String> map = new HashMap<>(map1);
        //map.putAll(map2);
        map2.forEach((k2, v2) -> map.merge(k2, v2, (m1, m2) -> m1 + "&" + m2));
        System.out.println(map);
    }

    public static void mapCount(Map<String, Long> map) {
        String  key = "a";
        map.merge(key, 1L, (k, v) -> v + 1);
    }

    /**
     * forEach/reduce/search
     * key/value/Entry
     */
    public static void concurrentHashMapDemo() {
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        long parallel = 1L;
        Optional<Long> max = Optional.ofNullable(map.reduceValues(parallel, Long::max));
    }
}
