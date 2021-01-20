package com.javahowdoi.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Hari on 2/2/2020.
 */
public class Limit {
    public static void main(String[] args ) {
        List<Integer> l = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6);
        List<Integer> l2 = l.stream().skip(2).limit(l.size()-2-2).collect(Collectors.toList());

        assertEquals("size matches", 8, l2.size());
        assertEquals("first element match", 2, l2.get(0).intValue());
        assertEquals("last element match", 5, l2.get(7).intValue());
    }
}
