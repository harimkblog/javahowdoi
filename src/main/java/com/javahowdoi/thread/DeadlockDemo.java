package com.javahowdoi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Hari on 12/31/2019.
 */
public class DeadlockDemo {
    private static class DeadlockTask implements Runnable {
        final Object s1 , s2;
        boolean order;
        DeadlockTask(Object s1, Object s2, boolean order) {
            this.s1 = s1; this.s2 = s2; this.order = order;
        }

        @Override
        public void run() {
            if(order)
            {
                synchronized(s1) {
                    System.out.println("Synchronized on s1.  About to wait for s2");
                    synchronized(s2) {
                        System.out.println("Got lock on s2.  Avoided deadlock ");
                    }
                }
            }
            else
            {
                // Note here that the order of synchronization is different
                // This can lead to deadlock is string objects s1 and s2 are shared
                synchronized(s2) {
                    System.out.println("Synchronized on s2.  About to wait for s1");
                    synchronized(s1) {
                        System.out.println("Got lock on s1.  Avoided deadlock ");
                    }
                }
            }
        }
    }

    public static void main(String[] args ) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        String s1 ="s1", s2 =  "s2";
        es.submit(new DeadlockTask(s1, s2, true));
        es.submit(new DeadlockTask(s1, s2, false));
        es.shutdown();
    }
}
