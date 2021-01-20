package com.javahowdoi.challengeq;

/**
 * Created by Hari on 1/11/2020.
 */
public class LockQ {
    public static class LockInner {
        public void acquire() {
            // acquire the resource
            //...
            // dummy print
            System.out.println("acquire");
        }
        public void release() {
            // resource release code
            //...
            //...
            // dummy print
            System.out.println("release");
        }
    }

    public static void main(String[] args) {
        LockInner li  = new LockInner();
        try {
            li.acquire();
        } finally {
            li.release();
        }
    }
}
