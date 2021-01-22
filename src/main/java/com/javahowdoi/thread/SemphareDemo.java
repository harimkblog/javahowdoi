package com.javahowdoi.thread;

import java.util.concurrent.*;

/**
 * Created by Hari on 12/31/2019.
 */
public class SemphareDemo {
    private static class SemaphoreTask implements Runnable{
        Semaphore sem;
        public SemaphoreTask(Semaphore sem) {
            this.sem = sem;
        }

        @Override
        public void run() {
            try {
                System.out.println( Thread.currentThread().getName() + " start" );
                // acquire a permit
                sem.acquire();
                Thread.sleep(1000);
                System.out.println( Thread.currentThread().getName() + " done" );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                sem.release();
            }
        }
    }

    public static void main(String[] args ) {
        // 5 threads competing for two resource
        Semaphore se  = new Semaphore(2);
        ExecutorService es  = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; ++i) {
            es.submit( new SemaphoreTask(se));
        }
        es.shutdown();
    }
}
