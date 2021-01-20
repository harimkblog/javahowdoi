package com.javahowdoi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Hari on 12/30/2019.
 */
public class PhaserDemo {
    private static class PhaserTask implements Runnable {
        private Phaser p;

        PhaserTask(Phaser p) {
            this.p = p;
            p.register();
        }

        @Override
        public void run() {
            p.arriveAndDeregister();
            //System.out.println("Exiting thread now");
        }
    }
    public static void main(String[] args) {
        Phaser p = new Phaser();
        p.register();
        assertEquals("In Phase 1", 0, p.getPhase());
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(new PhaserTask(p));
        es.submit(new PhaserTask(p));
        p.arriveAndAwaitAdvance();
        assertEquals("In Phase 1", 1, p.getPhase());
        es.submit(new PhaserTask(p));
        es.submit(new PhaserTask(p));
        p.arriveAndAwaitAdvance();
        assertEquals("In Phase 2", 2, p.getPhase());
        p.arriveAndDeregister();
        assertEquals("Registered parties 0", 0, p.getRegisteredParties() );
        es.shutdown();
    }
}
