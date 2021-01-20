package com.javahowdoi.challengeq;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hari on 11/24/2019.
 */
public class MapQ {
    @Data
    @AllArgsConstructor
    public static class MapInner {
        int i;
        int j;
    }
    public static void main(String[] args) {
        Map<MapInner, Integer> m = new HashMap<>();
        MapInner mi = new MapInner(0,1);
        m.put(mi, 0);
        mi.setI(2);
        System.out.println(m.get(mi));
    }
}
