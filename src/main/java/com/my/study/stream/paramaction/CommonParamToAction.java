package com.my.study.stream.paramaction;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author mdl
 * @Created 2021/5/19 10:29
 * @Description
 */
public class CommonParamToAction {

    /**
     * 通用predicate使用
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * 通用Consumer使用
     * @param list
     * @param c
     * @param <T>
     */
    public static <T> void myForEach(List<T> list, Consumer<T> c) {
        for (T e : list) {
            c.accept(e);
        }
    }

    /**
     * 通用Function使用
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static  <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return  result;
    }
}
