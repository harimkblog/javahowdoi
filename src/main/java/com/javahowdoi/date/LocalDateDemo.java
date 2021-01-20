package com.javahowdoi.date;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Hari on 1/18/2020.
 */
public class LocalDateDemo {
    public static void main(String[] args ) {
        // Date without time.
        LocalDate ld = LocalDate.now();
        System.out.println( ld.toString());
        // start of date and end of date times
        LocalDateTime sod = ld.atTime(LocalTime.MIDNIGHT);
        LocalDateTime eod = ld.atTime(LocalTime.MAX);
        System.out.println( sod.toString());
        System.out.println( eod.toString());


        // start of date with zone
        ZonedDateTime zdt = sod.atZone(ZoneId.systemDefault());
        System.out.println( zdt.toString());

        LocalDate ld1 = LocalDate.parse("2016-02-16");
        LocalDate som = ld1.with(TemporalAdjusters.firstDayOfMonth());
        ld1 = ld1.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println( som.toString());
        System.out.println( ld1.toString());
    }
}
