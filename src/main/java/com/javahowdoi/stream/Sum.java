package com.javahowdoi.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Hari on 1/28/2020.
 */
public class Sum {
    public static void main(String[] args ) {
        List<Integer> l = Arrays.asList(1,2,3,4,5,6);
        List<Integer> l1 = new ArrayList<>();
        // use collectors to sum integers
        int s = l.stream().collect(Collectors.summingInt(Integer::intValue));
        assertEquals("sum equals", 21, s);
        // returns 0 for empty list
        int s1 = l1.stream().collect(Collectors.summingInt(Integer::intValue));
        assertEquals("sum equals", 0, s1);

        // use IntStream to sum
        s = l.stream().mapToInt(Integer::intValue).sum();
        assertEquals("sum equals", 21, s);

        // use stream.reduce to sum
        // returns optional.  get int value from optional
        s = l.stream().reduce(Integer::sum).orElse(0);
        assertEquals("sum equals", 21, s);
        // provide seed.  returns int instead of Optional
        s = l1.stream().reduce(0, Integer::sum);
        assertEquals("sum equals", 0, s);
    }
}
