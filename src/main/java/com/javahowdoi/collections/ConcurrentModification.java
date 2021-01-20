package com.javahowdoi.collections;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Hari on 10/17/2019.
 */
public class ConcurrentModification {
    public static void simulateConcurrentModification() throws ConcurrentModificationException {
        List<Integer> l = new ArrayList<>();
        for(int i=0; i < 1000; ++i) {
            l.add(i);
        }

        Iterator<Integer> li = l.iterator();
        while(li.hasNext()) {
            Integer i = li.next();
            if(  i <= 200  && i >= 100 )
                l.add(i);
        }
    }

    private static void fixConcurrentModification() {
        List<Integer> l = new ArrayList<>();
        for(int i=0; i < 1000; ++i) {
            //l.add(i);
            l.add(i);
        }

        ListIterator<Integer> li = l.listIterator();
        ListIterator<Integer> li2 = l.listIterator();
        while(li.hasNext()) {
            Integer i = li.next();
            li2.next();
            if(  i <= 200  && i >= 100 )
                li.add(i);
        }
    }

    public static void simulateConcurrentModification2() throws ConcurrentModificationException {
        List<Integer> l = new ArrayList<>();
        for(int i=0; i < 1000; ++i) {
            l.add(i);
        }

        List<Integer> l2 =  Collections.synchronizedList(l);

        Iterator<Integer> li = l2.iterator();
        while(li.hasNext()) {
            Integer i = li.next();
            if(  i <= 200  && i >= 100 )
                l2.remove(i);
        }
    }

    public static void fixConcurrentModification2() {
        List<Integer> l = new CopyOnWriteArrayList<>();
        for(int i=0; i < 1000; ++i) {
            l.add(i);
        }

        ListIterator<Integer> li = l.listIterator();
        while(li.hasNext()) {
            Integer i = li.next();
            if(  i <= 200  && i >= 100 )
                l.add(i);
        }
    }
    public static void main(String[] args ) {
        //simulateConcurrentModification();
        fixConcurrentModification();
        //simulateConcurrentModification2();
        //fixConcurrentModification2();
    }
}
