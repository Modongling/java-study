package com.my.study.oop.generic;

import java.util.Collections;
import java.util.List;

public class GenericMethodTest {
    public static void main(String[] args) {
        /**
         * public static final <T> List<T> emptyList() {
         *         return (List<T>) EMPTY_LIST;
         *     }
         */
        List<String> list = Collections.emptyList();
        /**
         *  public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c){
         *  }
         */
        Collections.binarySearch(list,list,null);
    }
}

