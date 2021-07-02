package com.my.study.oop.dates;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateFormatterTest {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        LocalDateTime localDateTime = LocalDateTime.of(2021, 7, 3, 21, 58, 57, 59);
        System.out.println(localDateTime.format(formatter));
    }
}
