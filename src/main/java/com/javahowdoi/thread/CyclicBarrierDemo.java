package com.javahowdoi.thread;

import java.util.concurrent.*;

/**
 * Created by Hari on 12/15/2019.
 */
public class CyclicBarrierDemo {
    private static class TriggerTask implements Runnable{
        CyclicBarrier barrier;
        public TriggerTask(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.println("barrier count " + barrier.getNumberWaiting() + " " + Thread.currentThread().getName());
            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("wait over " + Thread.currentThread().getName() );
        }
    }

    public static void main(String[] args ) throws InterruptedException {
        CyclicBarrier cb  = new CyclicBarrier(5);
        ExecutorService es  = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; ++i) {
            es.submit( new  TriggerTask(cb));
        }

        es.shutdown();
        es.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("end");
    }
}
