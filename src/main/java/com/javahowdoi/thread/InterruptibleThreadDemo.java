package com.javahowdoi.thread;

        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;

public class InterruptibleThreadDemo {
    public static class InterruptibleRunner implements Runnable
    {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch(InterruptedException ie) {
                System.out.println("Thread interrupted");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es  = Executors.newFixedThreadPool(2); // create thread pool
        // executes Runnable tasks
        es.submit( new InterruptibleRunner());
        es.shutdownNow();
    }
}