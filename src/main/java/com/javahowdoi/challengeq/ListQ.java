package com.javahowdoi.challengeq;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Hari on 11/17/2019.
 */
public class ListQ {
private static List<Integer> l;

private static LinkedList<Integer> ll;
private static void filterQ() {
    ll = new LinkedList<>();
    IntStream.range(0, 100).forEach((i) -> ll.add(i));
    ll =  ll.stream().filter((i) -> i != 10 ).collect(Collectors.toCollection(LinkedList::new));

    ll.removeIf((i)->i == 10);
}


private static void removeA() {
    l = new LinkedList<>();
    IntStream.range(0, 100).forEach((i) -> l.add(i));
    l.remove(10);
}

private static void removeQ() {
    l = new ArrayList<>(100);
    IntStream.range(0, 100).forEach((i) -> l.add(i));
    l.remove(10);
}



    public static void main(String[] args) {
        removeQ();
        removeA();
        filterQ();
    }
}
