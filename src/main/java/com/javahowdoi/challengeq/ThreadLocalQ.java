package com.javahowdoi.challengeq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hari on 11/24/2019.
 */
public class ThreadLocalQ {
    public ThreadLocal<Long> tli = new ThreadLocal<>();

    private class TLQInner implements Runnable{

        @Override
        public void run() {
            try {
                tli.set(Thread.currentThread().getId());
                Thread.sleep(1000);
            } catch(Exception e) {}
        }
    }

    public TLQInner getInner() {
        return new TLQInner();
    }

    public static void main(String[] args ) {
        try {
            ThreadLocalQ tlq = new ThreadLocalQ();
            ExecutorService es = Executors.newFixedThreadPool(2);
            es.submit(tlq.getInner());
            es.submit(tlq.getInner());
            es.awaitTermination(2, TimeUnit.SECONDS);
            es.shutdown();
        } catch(Exception e ) {}
    }
}
