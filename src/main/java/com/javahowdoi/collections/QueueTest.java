package com.javahowdoi.collections;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Hari on 11/3/2019.
 */
public class QueueTest {
    private static void fifoQueue() {
        LinkedList<Integer> li = new LinkedList<>();
        for(int i = 0; i < 1000; ++i )
            li.add(i);
        for(int i = 0; i < 1000; ++i ) {
            Integer i1 = li.poll();
            assert ( i1 != null && i1 == i);
        }

        // returns null if there are no elements
        Integer i2 = li.poll();
        assert(  i2 == null );
        int s = li.size();
        assert( s == 0 );

        try {
            // throws an exception if there are no elements
            Integer r = li.remove();
        } catch( Exception e ) {
            assert( e instanceof NoSuchElementException);
            System.out.println("NoSuchElementException assertion passed");
        }
        System.out.println("all assertions passed");

    }

    public static void main( String[] args ) {
        fifoQueue();
    }
}
