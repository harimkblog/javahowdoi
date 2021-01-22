package com.javahowdoi.collections;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by Hari on 11/27/2019.
 */
public class WeakReferenceTest {
    public static void main(String[] args) throws InterruptedException {
        Integer wr = 200;
        Map<Integer, Integer> hm = new WeakHashMap<>();
        hm.put(wr, 100);
        System.out.println(hm.size());
        wr = null;
        System.gc();
        Thread.sleep(10000);
        System.out.println(hm.size());
    }
}
