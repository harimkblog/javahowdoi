package com.javahowdoi.collections;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static junit.framework.TestCase.*;

/**
 * Created by Hari on 1/18/2020.
 */
public class ConcurrentHSDemo {

    public static void main(String[] args ) {
    ConcurrentHashMap<String, Boolean> chm = new ConcurrentHashMap<>();
    chm.put("1", true);
    chm.put("2", false);
    assertEquals("size match", 2, chm.size());
    assertFalse("Key not found", chm.containsKey("3"));

    // Set is thread safe. Read operations are fully concurrent
    // updates have high expected concurrrency
    // Set updates result in ConcurrentHashMap update
    Set<String> s = chm.keySet(Boolean.TRUE);
    s.add("3");
    assertTrue("Key found", chm.containsKey("3"));
    }
}
