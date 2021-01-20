package com.javahowdoi.collections;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

import java.util.Collection;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Hari on 11/14/2019.
 */
public class MultilMap {
    public static void main(String[] args) {
        Multimap<Integer, Integer> mm = ArrayListMultimap.create();
        IntStream.range(1,100).forEach( (i) -> {mm.put(i, i); mm.put(i, i+1); });
        Collection<Integer> ai = mm.get(1);
        assertThat(ai).containsExactly(1, 2);

        MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
        map.put("a", "b");
        map.put("a", "c");
        Collection<String> c =  map.get("a");
        assertThat(c).containsExactly("b", "c");
    }
}
