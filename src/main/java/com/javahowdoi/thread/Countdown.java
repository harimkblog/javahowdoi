package com.javahowdoi.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hari on 12/15/2019.
 */
public class Countdown {
    private static class TriggerTask implements Runnable{
        CountDownLatch latch;
        public TriggerTask(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            latch.countDown();
            System.out.println("latch count" + latch.getCount());
        }
    }

    private static class TriggeredTask implements Runnable{
        CountDownLatch latch;
        public TriggeredTask(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println( "task triggered" );
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService es  = Executors.newFixedThreadPool(7);
        es.submit( new TriggeredTask(latch));
        es.submit( new TriggeredTask(latch));
        for(int i = 0; i < 5; ++i) {
            es.submit( new TriggerTask(latch));
        }
        es.shutdown();
        es.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("end");
    }
}
