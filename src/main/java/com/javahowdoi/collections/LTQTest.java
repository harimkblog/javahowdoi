package com.javahowdoi.collections;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LTQTest {
    public static void main(String[] args) {
        TransferQueue<Integer> tq = new LinkedTransferQueue<>();
        ExecutorService producer = Executors.newSingleThreadExecutor();
        ExecutorService consumer = Executors.newSingleThreadExecutor();
        producer.submit(() -> {
            try {
                // transfer an element.  blocking call
                // waits until consumer thread calls take()
                tq.transfer(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        consumer.submit(() -> {
            try {
                // blocking call.  waits until the element is in the queue
                System.out.println(tq.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.shutdown();
        consumer.shutdown();
    }
}
