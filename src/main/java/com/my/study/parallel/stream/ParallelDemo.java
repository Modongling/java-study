package com.my.study.parallel.stream;

import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author mdl
 * @Created 2021/5/29 7:32
 * @Description 串行，多任务一个一个的排队执行
 * 并行，线程同时被多个cpu执行
 * 并发，多线程被一个CPU轮流执行
 */
public class ParallelDemo {
    /**
     * 并行加法 累加器/迭代/计算
     * @param num
     * @return 过程类似于分治再归并
     */
    public static long parallelSum(long num) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(num)
                .parallel()
                .reduce(0L, Long::sum);
    }

    /**
     * 原理
     * ForkJoinPool
     * Runtime.getRuntime().availableProcessors()
     * System.setProperty("java.util.concurrent.ForkJoinPool.common parallelism", "12");
     */

    /**
     * 非原子操作的累加器
     * @param n
     * @return
     */
    public long sum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).forEach(accumulator::add);
        return accumulator.total;
    }

    public long parallelSum2(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    private static class Accumulator {
        private long total = 0;
        public void add(long value) {
            total += value;
        }
    }

    /**
     * 可应用于并行流的数据结构：
     * ArrayList -- 好
     * LinkedList -- 不好
     * IntStream.range 好
     * Stream.iterate -- 不好
     * HashSet -- 好
     * TreeSet -- 好
     */

    /**
     * ForkJoin
     */
    private static class ForkJoinTest extends RecursiveTask {

        @Override
        protected Object compute() {
            /**
             * if(小任务/不可分) {
             * 顺序执行
             * } else {
             * 递归拆分子任务，汇总结果
             * }
             */
            return null;
        }
    }
}
