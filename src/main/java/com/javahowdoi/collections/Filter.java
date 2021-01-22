package com.javahowdoi.collections;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark )
//@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup( time=1, iterations = 3, timeUnit = TimeUnit.MILLISECONDS )
@Measurement(time=1, timeUnit = TimeUnit.MILLISECONDS, iterations = 5)
public class Filter {
    private final List<Integer> l = new ArrayList<>(1000000);
    private final List<Integer> l1 = new LinkedList<>();

    @Setup()
    public void setup() {
        System.out.println( "In setup");
        for(int i=0; i < 1000000; ++i) {
            //l.add(i);
            l1.add(i);
        }
    }

    @Benchmark
    public List<Integer> filterWithFor() {
        List<Integer> l2 = new ArrayList<>();
        for(Integer i : l) {
            if( i <= 200 && i >= 100 )
                l2.add(i);
        }
        return l2;
    }

    @Benchmark
    public List<Integer> filterWithForEach() {
        List<Integer> l2 = new ArrayList<>();
        l.forEach( (x) -> { if(x <= 200 && x >= 100 ) l2.add(x); } );
        return l2;
    }

    @Benchmark
    public List<Integer> filterWithStreamForEach() {
        List<Integer> l2 = new ArrayList<>();
        l.stream()
         .filter( (Integer x) -> x <= 200 && x >= 100 )
         .forEach(l2::add);
        return l2;
    }

    @Benchmark
    public List<Integer> filterWithStreamAndCollect() {
        return l.stream()
                .filter( (Integer x) -> x <= 200 && x >= 100 )
                .collect( Collectors.toList());
    }

    @Benchmark
    public List<Integer> filterWithIterator() {
        List<Integer> l2 = new ArrayList<>();
        for (Integer i : l) {
            if (i <= 200 && i >= 100)
                l2.add(i);
        }
        //Collections.unmodifiableCollection();
        return l2;
    }

    @Benchmark
    public List<Integer> filterInPlace() {
        l.removeIf( (i) ->  i <= 200  && i >= 100 );
        return l;
    }

    @Benchmark
    public List<Integer> filterLLInPlace() {
        l1.removeIf( (i) ->  i <= 200  && i >= 100 );
        return l;
    }


    public static void main( String[] args ) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(Filter.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }
}