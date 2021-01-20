package com.javahowdoi.collections;

        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;
        import java.util.concurrent.LinkedBlockingQueue;
        import java.util.concurrent.TimeUnit;

/**
 * Created by Hari on 11/3/2019.
 */
public class BlockingQueueTest {
    private static final LinkedBlockingQueue<Integer> lbq = new LinkedBlockingQueue<>();

    private static void queueAdd() {
        for (int i = 0; i < 1000; ++i)
            lbq.add(i);
    }

    private static void queueReceive() {
        Integer i  = -1;
        try {
            while (i != null) {
                System.out.println(i);
                // blocking call
                i = lbq.poll(1, TimeUnit.SECONDS);
            }
        } catch(InterruptedException ie ) {
            throw new RuntimeException(ie.getMessage());
        }
    }
    public static void main(String[] args ) throws InterruptedException {
        ExecutorService prod = Executors.newSingleThreadExecutor();
        ExecutorService consumer = Executors.newSingleThreadExecutor();
        prod.submit( () -> queueAdd() );
        consumer.submit( () -> queueReceive());
        prod.awaitTermination(1, TimeUnit.SECONDS);
        consumer.awaitTermination(1, TimeUnit.SECONDS);
        prod.shutdown();
        consumer.shutdown();
    }
}
