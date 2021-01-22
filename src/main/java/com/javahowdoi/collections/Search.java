package com.javahowdoi.collections;

import java.util.*;

/**
 * Created by Hari on 11/9/2019.
 */
public class Search {

    public static void main(String[] args ) {
        int[] arr = {0,1,2,3,10,20,31,62};
        int idx  = Arrays.binarySearch(arr, 10);
        assert(idx == 4 );

        List<Integer> al =Arrays.asList( 0,1,2,3,10,20,31,62);

        Integer[] arr1 = (Integer[]) al.toArray();

        idx  = Collections.binarySearch(al, 10);
        assert(idx == 4 );
    }
}