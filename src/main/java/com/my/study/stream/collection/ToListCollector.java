package com.my.study.stream.collection;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * @author mdl
 * @Created 2021/5/28 17:13
 * @Description 把收集的元素放到List---toList
 */
public class ToListCollector <T> implements Collector<T, List<T>, List<T>> {
    /**
     *
     * @return 得到一个构造器
     */
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    /**
     *
     * @return 累加器，将元素添加到容器
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    /**
     *
     * @return 合并两个元素
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (l1, l2) -> {
            l1.addAll(l2);
            return l1;
        };
    }

    /**
     *
     * @return 返回结果对象
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    /**
     * 返回不变的characteristics集合
     * UNORDERED --不收累计和遍历影响
     * CONCURRENT -- 并行规约刘，无序数据源可以实现
     * IDENTITY_FINISH -- 恒等变换，累加器结果就是最终结果
     * @return
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(
                Characteristics.IDENTITY_FINISH,
                Characteristics.CONCURRENT
        ));
    }

    public static List<String> process() {
        ToListCollector<String> collector = new ToListCollector<>();
        List<String> strings = collector.supplier().get();
        collector.accumulator().accept(strings, "a");
        return collector.finisher().apply(strings);
    }

    public static List<String> processCombine() {
        ToListCollector<String> collector = new ToListCollector<>();
        List<String> strings = collector.supplier().get();
        List<String> strings2 = collector.supplier().get();
        collector.accumulator().accept(strings, "a");
        collector.accumulator().accept(strings2, "b");
        strings = collector.combiner().apply(strings, strings2);
        return collector.finisher().apply(strings);
    }


    public static void main(String[] args) {
        System.out.println(process());
        System.out.println(processCombine());
    }
}
