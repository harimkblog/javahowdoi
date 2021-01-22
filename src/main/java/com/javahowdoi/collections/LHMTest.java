package com.javahowdoi.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LHMTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> lhm = new LinkedHashMap<>();
        for(int i=0; i < 1000; ++i)
            lhm.put(i, i );
        // key based lookup
        assert( lhm.get(100) == 100 );
        // print in order of insertion
        //lhm.forEach((Integer k, Integer v) -> System.out.println(k));
        Iterator<Map.Entry<Integer, Integer>> it = lhm.entrySet().iterator();
        int i = 0;
        while(it.hasNext()) {
            Integer k = it.next().getKey();
            assert ( k == i);
            ++i;
        }
    }
}
