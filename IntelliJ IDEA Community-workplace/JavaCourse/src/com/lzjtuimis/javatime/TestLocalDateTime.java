package com.lzjtuimis.javatime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TestLocalDateTime {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);
        // 返回日期的年月日int类型
        int year = today.getYear();
        int month = today.getMonthValue();;
        int day = today.getDayOfMonth();
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);


        LocalDate dateOfBirthday = LocalDate.of(2002, 04, 06);
        MonthDay birthday = MonthDay.of(4, 6);
        MonthDay now = MonthDay.from(today);
        System.out.println(now);
        LocalTime time = LocalTime.now();
        System.out.println(time);
        System.out.println(time.getSecond());
        System.out.println(time.getNano());
        LocalDate newDate = today.plus(1, ChronoUnit.YEARS);
        System.out.println("一年后" + newDate);
        System.out.println("十年前" + today.minus(1, ChronoUnit.DECADES));
        System.out.println(today.isAfter(newDate));
        YearMonth ym = YearMonth.now();
        today.isLeapYear();
        Period p = Period.between(LocalDate.of(1900, 01, 01), today);
        System.out.println(p);
        System.out.println(p.getMonths());
        Instant i = Instant.now();
        System.out.println(i);
        System.out.println(i.getEpochSecond());
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime.getDayOfYear());
        /*字符串日期互转*/
        //日期转字符串
        LocalDateTime date = LocalDateTime.now();
        //日期显示yyyy-mm-dd，自定义转换的字符串格式
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String str = date.format(format1);
        System.out.println("日期转换为字符串:"+str);
        //字符串转日期
        String str2 = "2022-04-13";
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date2 = LocalDate.parse(str2, format2);
        System.out.println("日期类型:" + date2);
        //转时间
        String str3 = "11:10:46";
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time1 = LocalTime.parse(str3, format3);
        System.out.println("时间类型:" + time1);

    }
}
