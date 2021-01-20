package com.javahowdoi.algo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Hari on 2/11/2020.
 */
public class sort {
    private static void is(List<Integer> l) {
        //10, 9, 8, 7, 6, 5
        int s = l.size();
        int i = 1;
        for(; i < s; ++i ) {
            int j = i-1;
            for( ; j >= 0; --j ) {
                if( l.get(j+1) > l.get(j) ) {
                    int e = l.get(j);
                    l.set( j, l.get(j+1));
                    l.set( j+1, e);
                }
                else
                    break;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> l = IntStream.range(1,100).boxed().collect(Collectors.toList());
        System.out.println(l.toString());
        is(l);
        System.out.println(l.toString());
    }
}
