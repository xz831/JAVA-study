package com.xz.java8time;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @Package: com.xz.java8time
 * @ClassName: ZonedDateTimeMain
 * @Author: xz
 * @Date: 2020/4/18 21:20
 * @Version: 1.0
 */
public class ZonedDateTimeMain {

    private static ZoneId los_Angeles = ZoneId.of(ZoneId.SHORT_IDS.get("PST"));

    public static void main(String[] args) {
//        test1();
//        test2();
//        test3();
        test4();
    }

    private static void test1(){
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        ZonedDateTime zny = ZonedDateTime.now(los_Angeles); // 用指定时区获取当前时间
        System.out.println(zbj);
        System.out.println(zny);
    }

    private static void test2(){
        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zbj = ldt.atZone(ZoneId.systemDefault());
        ZonedDateTime zny = ldt.atZone(los_Angeles);
        System.out.println(zbj);
        System.out.println(zny);
    }

    private static void test3(){
        // 以中国时区获取当前时间:
        ZonedDateTime zbj = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        // 转换为纽约时间:
        ZonedDateTime zny = zbj.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(zbj);
        System.out.println(zny);
    }

    //某航线从北京飞到纽约需要13小时20分钟，请根据北京起飞日期和时间计算到达纽约的当地日期和时间。
    private static void test4(){
        if (!LocalDateTime.of(2019, 10, 15, 14, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 10, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        } else if (!LocalDateTime.of(2019, 11, 15, 13, 20, 0)
                .equals(calculateArrivalAtNY(LocalDateTime.of(2019, 11, 15, 13, 0, 0), 13, 20))) {
            System.err.println("测试失败!");
        }
    }

    static LocalDateTime calculateArrivalAtNY(LocalDateTime bj, int h, int m) {
        ZonedDateTime zdt = ZonedDateTime.of(bj,ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zonedDateTime = zdt.withZoneSameInstant(ZoneId.of("America/New_York"));
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();
        return localDateTime.plusHours(h).plusMinutes(m);
    }
}
