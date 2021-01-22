package com.javahowdoi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.stream.IntStream;

import static junit.framework.TestCase.*;

/**
 * Created by Hari on 11/10/2019.
 */
public class Find {
    public static void main(String[] args ) {
        List<Integer> l = new ArrayList<>();
        IntStream.range(0,100).forEach(l::add);
        boolean b = l.contains(10);
        assertTrue("list contains 10", b);

        b = l.contains(100);
        assertFalse("", b);
        int idx = l.indexOf(10);
        assertEquals("index of 10 is 9", 10, idx );

        Optional<Integer> o = l.stream().filter((i)-> i == 10).findAny();
        b = o.isPresent();
        assertTrue("Found element 10", b);

        ConcurrentSkipListMap<Integer, Integer > csm = new ConcurrentSkipListMap<>();
        IntStream.range(0,100).forEach((i)->csm.put(i,i));
        Map.Entry<Integer, Integer> e = csm.floorEntry(100);
        assertEquals("", 99, e.getKey().intValue() );
        e = csm.floorEntry(90);
        assertEquals("", 90, e.getKey().intValue() );

        e = csm.ceilingEntry(-1);
        assertEquals("", 0, e.getKey().intValue() );
        e = csm.ceilingEntry(90);
        assertEquals("", 90, e.getKey().intValue() );


        e = csm.higherEntry(10);
        assertEquals("", 11, e.getKey().intValue() );

        e = csm.lowerEntry(10);
        assertEquals("", 9, e.getKey().intValue() );
    }
}
