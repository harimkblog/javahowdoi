package com.javahowdoi.collections;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hari on 10/5/2019.
 */
public class Distinct {
    private static void distinctWithStream() {
        List<Integer> list = Arrays.asList(100, 100, 200, 300, 300, 400, 500, 600);

        // Displaying the distinct elements in the list
        // using Stream.distinct() method
        List<Integer> l2 = list.stream().distinct().collect(Collectors.toList());
        List<Integer> l3 = Arrays.asList(100, 200, 300, 400, 500, 600);
        assertEquals("stream distinct ", l2 ,l3);
    }

    private static void distinctWithHashSet() {
        List<Integer> list = Arrays.asList(100, 100, 200, 300, 300, 400, 500, 600);
        List<Integer> l2 = Arrays.asList(100, 200, 300, 400, 500, 600);

        HashSet<Integer> si = new HashSet<>(list);
        List<Integer> l4 = new ArrayList<Integer>(si);
        System.out.println( l4.size() == l2.size() ?  "Size matches" :  "Size does not match" );
        System.out.println( !l2.equals(l4) ? "Order not maintained " : "Order maintained " );
    }

    private static void distinctWithLinkedHashSet() {
        List<Integer> list = Arrays.asList(100, 100, 200, 300, 300, 400, 500, 600);
        List<Integer> l2 = Arrays.asList(100, 200, 300, 400, 500, 600);

        HashSet<Integer> si = new LinkedHashSet<>(list);
        List<Integer> l4 = new ArrayList<Integer>(si);
        System.out.println( l4.size() == l2.size() ?  "Size matches" :  "Size does not match" );
        System.out.println( !l2.equals(l4) ? "Order not maintained " : "Order maintained " );
    }

    public static void main( String[] args ) {
        distinctWithStream();
        distinctWithHashSet();
        distinctWithLinkedHashSet();
    }
}
