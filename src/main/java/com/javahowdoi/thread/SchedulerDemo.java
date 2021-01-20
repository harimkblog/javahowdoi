package com.javahowdoi.thread;

        import java.util.concurrent.Executors;
        import java.util.concurrent.ScheduledExecutorService;
        import java.util.concurrent.TimeUnit;

/**
 * Created by Hari on 12/20/2019.
 */
public class SchedulerDemo {
    public static void main(String[] args ) throws InterruptedException {
        ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
        // executes threads at scheduled rate
        es.scheduleAtFixedRate(() -> System.out.println("beep"), 1, 1, TimeUnit.SECONDS);
        Thread.sleep(5000);
        es.shutdown();
    }
}
