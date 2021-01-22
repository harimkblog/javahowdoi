package com.javahowdoi.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Hari on 11/7/2019.
 */
public class PriorityQueueTest {
    public static void main(String[] args ) {
        Comparator<Integer> c = (o1, o2) -> {
            return Integer.compare(o2, o1);
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(100, c);
        for(int i = 0; i < 10; ++i)
            pq.add(i);
        for(int i = 0; i < 10; ++i)
            System.out.println(pq.poll());
    }
}
