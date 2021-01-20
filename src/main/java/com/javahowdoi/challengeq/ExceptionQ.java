package com.javahowdoi.challengeq;

import java.io.IOException;

/**
 * Created by Hari on 6/13/2020.
 */
public class ExceptionQ {
    private static void f() {
        try {
            System.out.println("throwing exception");
            throw new IOException("Test exception");
        } catch(IOException ie) {
            System.out.println("Caught IOException " + ie.getMessage());
        } catch(Exception e) {
            System.out.println("Caught exception " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        f();
    }
}
