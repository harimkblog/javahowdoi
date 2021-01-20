package com.javahowdoi.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Hari on 2/4/2020.
 */
public class FlatMap {
    public static void main(String[] args ) {
        List<List<String>> ll = Arrays.asList( Arrays.asList("1a", "2a", "3a"), Arrays.asList("4a", "5a", "6a") );
        //ll.stream().flatMap(Collection::stream).forEach(System.out::println);
        ll.stream().flatMapToInt(x -> x.stream().mapToInt(Objects::hashCode)).forEach(System.out::println);
    }
}
