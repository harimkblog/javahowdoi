package com.javahowdoi.collections;

import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.IntStream;

/**
 * Created by Hari on 9/22/2019.
 */
public class IteratorOrder {
    public static void concurrentExceptionDemo() {
        List<Integer> l = new LinkedList<>();
        for( int i =0; i < 100; ++i)
            l.add(i);

        ListIterator<Integer> li = l.listIterator();
        try {
            while (li.hasNext()) {
                Integer i = li.next();
                if (i >= 50)
                    l.remove(i);
            }
        } catch(ConcurrentModificationException cme) {
            System.out.println(cme.toString());
        }
    }


    public static void concurrentExceptionFix() {
        List<Integer> l = new LinkedList<>();
        for( int i =0; i < 100; ++i)
            l.add(i);

        ListIterator<Integer> li = l.listIterator();
        try {
            while (li.hasNext()) {
                Integer i = li.next();
                if (i >= 50)
                    li.remove();
            }
        } catch(ConcurrentModificationException cme) {
            System.out.println(cme.toString());
        }
        l.forEach((x)->System.out.println(x));
    }

    public static void iteratorAdd() {
                List<Integer> l = new LinkedList<>();
                for( int i =0; i < 100; ++i)
                    l.add(i);

        ListIterator<Integer> li = l.listIterator();
        while(li.hasNext()) {
            li.add(li.next() + 100);
        }
        l.forEach((x)->System.out.println(x));
    }

    public static void main( String[] args) {
        /**iteratorAdd();
        concurrentExceptionDemo();
        concurrentExceptionFix();
**/
        int[] p = { 1,2,3,4,5 };
        IntStream is = IntStream.of( p );
        is.forEach( x -> System.out.println( x ) );
    }
}

