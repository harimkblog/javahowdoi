package com.javahowdoi.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Hari on 1/25/2020.
 */
public class ParseDemo {
    public static void main(String[] args ) {
        LocalDate ld = LocalDate.parse("2016-12-01");
        LocalDateTime ldt = LocalDateTime.parse("2016-12-01T01:00:00");
        ZonedDateTime zdt = ZonedDateTime.parse("2016-12-01T01:00:00-05:00");
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE.format(ld));
        //System.out.println(DateTimeFormatter.ISO_OFFSET_DATE.format(ld));
        System.out.println(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(ldt));
        DateTimeFormatter fb = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
        System.out.println(zdt.format( fb ));

        LocalDateTime ldt2 = LocalDateTime.parse("01-Dec-2019 01:00:00", fb );
        System.out.println(ldt2.toString());

    }
}
