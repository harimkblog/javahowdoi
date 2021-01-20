package com.javahowdoi.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Hari on 2/9/2020.
 */
public class TakeWhile {
    public static void main(String[] args ) {
        IntStream is = IntStream.of(1,100);
        List<Integer> l = Arrays.asList(1,2,3,4,5);
        int i  = 0;
        //l.stream().reduce(x -> i += x).filter( i <= 8 ).collect(Collectors.toList());
//IntStream is = IntStream.of(1,100);
//List<Integer> l = is.takeWhile(x-> x <= 7).collect(Collectors.toList());
    }
}
