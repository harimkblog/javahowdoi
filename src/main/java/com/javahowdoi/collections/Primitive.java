package com.javahowdoi.collections;

import gnu.trove.list.array.TIntArrayList;
import it.unimi.dsi.fastutil.ints.IntArrayList;

import java.util.function.IntConsumer;

/**
 * Created by Hari on 10/28/2019.
 */
public class Primitive {
    private static void trove() {
        TIntArrayList ti = new TIntArrayList();
        for( int i = 0; i < 1000; ++i)
            ti.add(i);
        for( int i = 0; i < 1000; ++i)
            ti.set(i, i+1);
    }

    private static void fastutil() {
        IntArrayList il = new IntArrayList();
        for( int i = 0; i < 1000; ++i)
            il.add(i);
        il.forEach((IntConsumer) System.out::println);
    }

    public static void main(String[] args ) {
        trove();
        fastutil();
    }
}
