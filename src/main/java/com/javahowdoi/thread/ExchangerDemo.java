package com.javahowdoi.thread;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Hari on 12/31/2019.
 */
public class ExchangerDemo {
    private static class ExchangerTask implements Runnable {
        Exchanger<Double> ei;
        ExchangerTask(Exchanger<Double> ei ) {
            this.ei = ei;
        }

        @Override
        public void run() {
            try {
                Double i = Math.random();
                System.out.println(Thread.currentThread().getName() + " sending # " + i.toString());
                i = ei.exchange(i);
                System.out.println(Thread.currentThread().getName() + " received # " + i.toString());
            }
            catch(InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args ) {
        Exchanger<Double> ei = new Exchanger<>();
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(new ExchangerTask(ei));
        es.submit(new ExchangerTask(ei));
        es.shutdown();
    }
}
