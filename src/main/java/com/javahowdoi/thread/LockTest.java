package com.javahowdoi.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Hari on 12/8/2019.
 */
public class LockTest {
    final ReadWriteLock lock = new ReentrantReadWriteLock();
    int i;

    public LockTest() {}

    public int getI() {
        Lock rl= lock.readLock();
        try {
            rl.lock();
        }
        finally {
            rl.unlock();
        }
        return i;
    }

    public void increment() {
        Lock wl= lock.writeLock();
        try {
            wl.lock();
            ++i;
        }
        finally {
            wl.unlock();
        }
    }

    private static class LockTask implements Runnable {
        final LockTest lt;
        final boolean write;

        public LockTask(LockTest lt, boolean write) {
            this.lt = lt;
            this.write = write;
        }

        @Override
        public void run() {
            if(write) {
                System.out.println( "In write mode" );
                lt.increment();
            }
            else {
                System.out.println( "In read mode" );
                System.out.println( lt.getI() );
            }
        }
    }
    public static void main(String[] args) {
        LockTest test = new LockTest();
        LockTask write = new LockTask(test, true);
        LockTask read = new LockTask(test, false);
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.submit(write);
        es.submit(read);
        es.submit(write);
        es.submit(read);
        es.submit(read);
        es.shutdown();
    }
}
