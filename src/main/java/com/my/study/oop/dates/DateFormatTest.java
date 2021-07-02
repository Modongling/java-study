package com.my.study.oop.dates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {
    public static void main(String[] args) {
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);
        System.out.println(dateFormat.format(new Date()));
        final String s = "yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(s);
        try {
            Date date = format.parse("2021-07-03");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(format.format(new Date()));
    }
}
