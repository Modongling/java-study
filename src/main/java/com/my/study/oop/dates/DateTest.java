package com.my.study.oop.dates;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        Date date2 = new Date(System.currentTimeMillis() + 100L);
        System.out.println(date2);
        //< -1 = 0 > 1
        System.out.println(date.compareTo(date2));
        System.out.println(date.before(date2));
        /**
         * before()
         * after()
         * getTime()
         */
    }
}
