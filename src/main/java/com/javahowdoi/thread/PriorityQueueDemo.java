package com.javahowdoi.thread;

import java.util.concurrent.*;

/**
 * Created by Hari on 12/7/2019.
 */
public class PriorityQueueDemo {
    private static class QueueItem {
        final private int i;

        public QueueItem(int i) {
            this.i = i;
        }

        public int getI() {return i;}
    }

    private static class LoopingTask implements Runnable {
        final BlockingQueue<QueueItem> bq ;

        public LoopingTask(BlockingQueue<QueueItem> bq ) {
            this.bq = bq;
        }

        @Override
        public void run() {
            try {
                while(true) {
                    System.out.println(bq.take().getI());
                }
            } catch(Exception e) {}
        }
    }
    public static void main(String[] args) {
        BlockingQueue<QueueItem> pbq = new PriorityBlockingQueue<>(10,
                (QueueItem o1, QueueItem o2) -> {
                    if( o1.getI() > o2.getI() )
                        return -1;
                    if( o1.getI() == o2.getI() )
                        return 0;
                    return 1;
                }
                );
        ExecutorService tpe = Executors.newSingleThreadExecutor();
        QueueItem c1 = new QueueItem(10);
        QueueItem c2 = new QueueItem(20);
        pbq.add(c1);
        pbq.add(c2);
        tpe.submit( new LoopingTask(pbq) );
        tpe.shutdown();
    }
}
