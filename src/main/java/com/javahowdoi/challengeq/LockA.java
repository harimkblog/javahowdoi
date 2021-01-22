package com.javahowdoi.challengeq;

public class LockA {
    public static class LockInner implements AutoCloseable {
        public void acquire() {
            // acquire the resource
            //...
            // dummy print
            System.out.println("acquire");
        }

        @Override
        public void close() {
            // resource release code
            //...
            //...
            // dummy print
            System.out.println("release");
        }
    }

    public static void main(String[] args) throws Exception {
        try(LockInner li  = new LockInner()) {
            li.acquire();
        }
    }
}