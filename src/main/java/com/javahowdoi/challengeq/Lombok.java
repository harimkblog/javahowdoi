package com.javahowdoi.challengeq;

import lombok.Data;
import lombok.NonNull;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Hari on 11/24/2019.
 */
@Data
public class Lombok {
    @NonNull
    private Integer i;
    @NonNull
    private String s;

    public static void main(String[] args ) {
        Lombok l = new Lombok(0, "test");
        assertEquals("test get int method", (Integer) 0, l.getI());
        assertEquals("test get string method", "test", l.getS());
    }
}
