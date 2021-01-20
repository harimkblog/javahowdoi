package com.javahowdoi.collections;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;
import static org.junit.Assert.*;

/**
 * Created by Hari on 10/1/2019.
 */
public class Reverse {
    private static List<Integer> reverseWitItereator(List<Integer> l) {
        List<Integer> l2 = new ArrayList<>();
        ListIterator<Integer> rev = l.listIterator(l.size());
        while(rev.hasPrevious()) {
            l2.add(rev.previous());
        }
        return l2;

    }

    private static List<Integer> reverseWithStream(List<Integer> l) {
        return l.stream().map((i) -> l.size()-1-i ).collect(Collectors.toList());
    }

    public static void reverseInPlace(List<Integer> l) {
        Collections.reverse(l);
    }

    private static List<Integer> reverView(List<Integer> l) {
        return Lists.reverse(l);
    }

    public static void main( String[] args ) {
        List<Integer> l1 = new ArrayList<>();
        for(int i=0; i < 100; ++i) {
            l1.add(i);
        }
        reverseWitItereator(l1);
        reverseWithStream(l1);
        System.out.println("end");
        String s = "a";
        if(s.charAt(0) == 'a')
            System.out.println("hello");

        List<Integer> l2 = l2 = reverView(l1);
        l1.add(101);
        assertEquals("reverse check", l2.get(0).longValue(), 101);
    }
}
