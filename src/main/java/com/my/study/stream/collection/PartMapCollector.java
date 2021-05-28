package com.my.study.stream.collection;

import com.my.study.stream.StreamCollectionDemo;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * @author mdl
 * @Created 2021/5/28 18:42
 * @Description
 */
public class PartMapCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> new HashMap<Boolean, List<Integer>>() {
            {
                put(true, new ArrayList<>());
                put(false, new ArrayList<>());
            }
        };
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (Map<Boolean, List<Integer>> accumulator, Integer candidate) -> {
            accumulator.get(isPrime(accumulator.get(true), candidate))
                    .add(candidate);
        };
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
        return (Map<Boolean, List<Integer>> m1, Map<Boolean, List<Integer>> m2) -> {
            m1.get(true).addAll(m2.get(true));
            m1.get(false).addAll(m2.get(false));
            return m1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(
                Characteristics.IDENTITY_FINISH
        ));
    }

    public static boolean isPrime(List<Integer> prime, int candidate) {
        int root = (int) Math.sqrt((double) candidate);
        return MyCollectionUtils.takeWhile(prime, i -> i <= root)
                .stream()
                .noneMatch(p -> candidate % p == 0);
    }

    public static void partitioningByPrime(int num) {
       StreamCollectionDemo.partPrimes(num);
    }

    public static Map<Boolean, List<Integer>> myPartitionMap(int num) {
        return IntStream.rangeClosed(2, num).boxed()
                .collect(new PartMapCollector());
    }

    public static void main(String[] args) {
        long max = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            //partitioningByPrime(1_000_000);
            myPartitionMap(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < max) {
                max = duration;
            }
            System.out.println("Execution time:" + max);
        }
    }
}
