package com.javahowdoi.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Hari on 10/8/2019.
 */
public class FilterMap {

    private static void filterWithStream() {
        HashMap<Integer, Integer> m = new HashMap<>();
        for( int i =0; i < 10000; ++i)
            m.put(i, i);

        Map<Integer, Integer> m1 = m.entrySet().stream()
                .filter((x) -> x.getKey() > 200 || x.getKey() < 100 )
                .collect(Collectors.toMap( Map.Entry::getKey, Map.Entry::getValue));

        System.out.println( m.size() );
        System.out.println( m1.size() );
    }

    private static void filterInplacewithRemove() {
        HashMap<Integer, Integer> m = new HashMap<>();
        for( int i =0; i < 10000; ++i)
            m.put(i, i);

        System.out.println( m.size() );

        m.entrySet().removeIf((x) -> x.getKey()<= 200 && x.getKey() >= 100 );
        System.out.println( m.size() );

    }

    private static void filterInplacewithIterator() {
        HashMap<Integer, Integer> m = new HashMap<>();
        for( int i =0; i < 10000; ++i)
            m.put(i, i);

        System.out.println( m.size() );

        Iterator<Map.Entry<Integer, Integer>> i = m.entrySet().iterator();
        while( i.hasNext() ) {
            Map.Entry<Integer, Integer> e = i.next();
            if(e.getKey() <= 200 && e.getKey() >= 100 )
                i.remove();
        }
        System.out.println( m.size() );
    }
    public static void main(String[] args ) {
        filterWithStream();
        filterInplacewithRemove();
        filterInplacewithIterator();
    }
}

