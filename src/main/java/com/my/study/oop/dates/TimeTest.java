package com.my.study.oop.dates;

import java.time.*;

public class TimeTest {
    public static void main(String[] args) {
        //获取系统时期
        Clock clock = Clock.systemUTC();
        System.out.println(clock.instant());
        System.out.println(clock.millis());
        //获取对应秒数的时间
        Duration duration = Duration.ofSeconds(6000L);
        System.out.println(duration.toMinutes());
        System.out.println(duration.toHours());
        System.out.println(duration.toDays());

        //当前时间增加6000s的时间
        Clock clock2 = Clock.offset(clock, duration);
        System.out.println(clock2.instant());

        Instant instant = Instant.now();
        System.out.println(instant);
        //当前时间+6000
        Instant instant2 = instant.plusSeconds(6000L);
        System.out.println(instant2);
        Instant instant3 = Instant.parse("2021-06-21T00:08:25.284Z");
        System.out.println(instant3);
        //+2h4min
        Instant instant4 = instant3.plus(Duration.ofHours(2).plusMinutes(4));
        System.out.println(instant4);
        //获取5天前的时间
        Instant instant5 = instant4.minus(Duration.ofDays(5));
        System.out.println(instant5);

        //获取当前日期
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        localDate = LocalDate.of(2021, Month.JUNE, 22);
        System.out.println(localDate);

        //获取当前时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        //当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        Year year = Year.now();
        System.out.println(year);

        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);

        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay);

    }
}
