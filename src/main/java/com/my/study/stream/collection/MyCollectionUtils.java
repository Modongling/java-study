package com.my.study.stream.collection;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author mdl
 * @Created 2021/5/28 18:33
 * @Description
 */
public class MyCollectionUtils {
    /**
     * 返回符合条件的最长子序列
     * @param list
     * @param p
     * @param <T>
     * @return
     */
    public static <T> List<T> takeWhile(List<T> list, Predicate<T> p) {
        //记录最长队列
        int i= 0;
        for (T item : list) {
            if (!p.test(item)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }
}
