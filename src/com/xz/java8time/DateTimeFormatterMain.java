package com.xz.java8time;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @Package: com.xz.java8time
 * @ClassName: DateTimeFormatterMain
 * @Author: xz
 * @Date: 2020/4/18 21:50
 * @Version: 1.0
 */
public class DateTimeFormatterMain {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test1(){
        ZonedDateTime zdt = ZonedDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm ZZZZ");
        System.out.println(formatter.format(zdt));

        DateTimeFormatter zhFormatter = DateTimeFormatter.ofPattern("yyyy MMM dd EE HH:mm", Locale.CHINA);
        System.out.println(zhFormatter.format(zdt));

        DateTimeFormatter usFormatter = DateTimeFormatter.ofPattern("E, MMMM/dd/yyyy HH:mm", Locale.US);
        System.out.println(usFormatter.format(zdt));
    }

    private static void test2(){
        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTimeFormatter.format(ldt));

        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy MMM dd HH:mm:ss.SSS E");
        System.out.println(dateTimeFormatter1.format(ldt));
    }
}
