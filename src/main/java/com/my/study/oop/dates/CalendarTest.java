package com.my.study.oop.dates;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);

        Calendar calendar3 = Calendar.getInstance();
        System.out.println(calendar3.get(Calendar.YEAR));
        //月份起始值是0
        System.out.println(calendar3.get(Calendar.MONTH));
        System.out.println(calendar3.get(Calendar.DATE));
    }
}
