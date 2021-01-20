package com.javahowdoi.thread;

import java.util.concurrent.*;

/**
 * Created by Hari on 12/4/2019.
 */
public class ProducerConsumer {
    private static class Task<T> implements Runnable{
        private T e;
        public Task(T e) {
            this.e = e;
        }

        @Override
        public void run() {
            System.out.println(e);
        }
    }

    private static void withExecutorService() throws InterruptedException {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(new Task<Integer>(100));
        es.submit(new Task<Integer>(200));
        es.shutdown();
    }

    private static class QueueProducer implements Runnable{
        BlockingQueue<Integer> bq ;
        public QueueProducer(BlockingQueue<Integer> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            for(int i =0; i < 100; ++i )
                bq.add(i);
        }
    }

    private static class QueueConsumer implements Runnable{
        BlockingQueue<Integer> bq ;
        public QueueConsumer(BlockingQueue<Integer> bq) {
            this.bq = bq;
        }

        @Override
        public void run() {
            try {
                while(true)
                    System.out.println(bq.take());
            } catch(InterruptedException ie ) {
                System.out.println("thread interrupted");
            }
        }
    }

    private static void producerConsumer() throws InterruptedException {
        BlockingQueue<Integer> bq = new LinkedBlockingQueue<>();
        Thread t1 = new Thread(new QueueProducer(bq));
        Thread t2 = new Thread(new QueueConsumer(bq));
        t1.start();
        t2.start();
        t1.join();
        t2.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        withExecutorService();
        producerConsumer();
    }
}
