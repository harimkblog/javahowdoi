package com.javahowdoi.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Hari on 12/14/2019.
 */
public class LockIssue {
    private int i;
    private Lock l = new ReentrantLock();

    public int getI() {
        try {
            l.lock();
            return i;
        } finally {l.unlock();}
    }

    public void setI(int i) {
        try {
            l.lock();
            reallySetI(i);
        } finally {l.unlock();}
    }

    private void reallySetI(int i ) {
        try {
            l.lock();
            this.i = i;
        } finally {l.unlock();}
    }

    public static void main(String[] args) {

        LockIssue li = new LockIssue();
        li.setI(100);
        System.out.println(li.getI());
    }

}
