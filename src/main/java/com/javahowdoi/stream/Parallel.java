package com.javahowdoi.stream;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Hari on 2/12/2020.
 */
public class Parallel {
    public static void main(String[] args ) throws ExecutionException, InterruptedException {
        List<Integer> l = IntStream.range(1,10).boxed().collect(Collectors.toList());
        int sum = l.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        sum = l.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);

        ForkJoinPool fjp = new ForkJoinPool(4);
        sum = fjp.submit(
            () -> l.parallelStream().mapToInt(Integer::intValue).sum() ).get();
        System.out.println(sum);
    }
}
