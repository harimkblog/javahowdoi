package com.javahowdoi.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Hari on 2/5/2020.
 */
public class SplitIt {
    public static void main(String[] args ) {
        List<String> ll = Arrays.asList("1a", "2a", "3a", "4a", "5a", "6a" );
        Spliterator<String> s = ll.spliterator();
        assertEquals("spliterator size match", 6, s.getExactSizeIfKnown());
        Spliterator<String> s2 = s.trySplit();
        assertEquals("spliterator size match", 3, s.getExactSizeIfKnown());
        assertEquals("spliterator size match", 3, s2.getExactSizeIfKnown());
        s.forEachRemaining(System.out::println);
        s2.forEachRemaining(System.out::println);
    }
}
