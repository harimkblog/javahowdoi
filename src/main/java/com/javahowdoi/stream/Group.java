package com.javahowdoi.stream;

import java.util.*;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Hari on 1/30/2020.
 */
public class Group
{
    private static class Inner {
        public int i;
        public String s;

        public static Integer getI(Inner in) {return in.i;}

        @Override
        public boolean equals(Object other) {
            if(!(other instanceof Inner))
                return false;
            Inner i2 = (Inner) other;
            return this.i == i2.i ;
        }

        @Override
        public int hashCode() {
            return this.i;
        }
    }

    public static void main(String[] args ) {
        List<Integer> l = Arrays.asList(1, 2, 3, 3, 4, 5,5, 6);
        List<Inner> li = new ArrayList<>();
        for(int i=0; i < 5;  ++i) {
            Inner in = new Inner();
            in.i = i; in.s = String.format("%d", i);
            li.add(in); li.add(in);
        }

        assertEquals("map size match", 10, li.size() );
        Map<Integer, List<Inner>> m = li.stream().collect(Collectors.groupingBy(Inner::getI));
        assertEquals("map size match", 5, m.size() );
        // assert each sub list is of size 2
        for(int i=0; i < 5;  ++i) {
            List<Inner> lg = m.get(i);
            assertEquals("Set size match", 2, lg.size() );
        }
        Map<Integer, Set<Inner>> m1 = li.stream().collect(Collectors.groupingBy(Inner::getI, Collectors.toSet()));
        assertEquals("map size match", 5, m1.size() );
        // assert each sub set is of size 1
        for(int i=0; i < 5;  ++i) {
            Set<Inner> s = m1.get(i);
            assertEquals("Set size match", 1, s.size() );
        }

        Map<Integer, Integer> m2 = li.stream().collect(Collectors.groupingBy(Inner::getI, Collectors.summingInt(Inner::getI)));
        for(int i=0; i < 5;  ++i) {
            int sum = m2.get(i);
            assertEquals("Set size match", i * 2, sum );
        }
    }
}
