package com.javahowdoi.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Hari on 11/7/2019.
 */
public class StackTest {

    private static void lifoQueue() {
        LinkedList<Integer> li = new LinkedList<>();
        Queue<Integer> q = Collections.asLifoQueue(li);
        for( int i=0; i<1000; ++i) {
            q.add(i);
        }
        int i = q.poll();
        assert(i == 999 );
    }

    private static void incorrectLifoQueue() {
        LinkedList<Integer> li = new LinkedList<>();
        for( int i=0; i<1000; ++i) {
            li.add(i);
        }
        Queue<Integer> q = Collections.asLifoQueue(li);
        int i = q.poll();
        assert(i == 0);
    }

    private static void stack() {
        Stack<Integer> si = new Stack<>();
        for( int i=0; i<1000; ++i) {
            si.push(i);
        }
        int i = si.pop();
        assert(i == 999);
    }

    public static void main( String[] args ) {
        lifoQueue();
        incorrectLifoQueue();
        stack();
    }
}
