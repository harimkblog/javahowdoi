package com.javahowdoi.thread;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Hari on 12/14/2019.
 */
public class LockIssue2 {
    private int i;
    private ReadWriteLock l = new ReentrantReadWriteLock();

    public int getI() {
        l.readLock().lock();
        int t = i;
        l.readLock().unlock();
        return t;
    }

    public void setI(int i) {
        l.writeLock().lock();
        this.i = i;
        l.writeLock().unlock();
    }

    public static void main(String[] args) {
        LockIssue li = new LockIssue();
        li.setI(100);
        System.out.println(li.getI());
    }
}
