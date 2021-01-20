package com.javahowdoi.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Hari on 10/24/2019.
 */
public class Unmodifiable {

    static class inner {
        private int i;

        inner(int i) {
            this.i = i;
        }

        public int getI() {
            return i;
        }

        public void setI( int _i) {
            i = _i;
        }
    }
    public static void main(String[] args ) {
        List<inner> l = new ArrayList<>(1000);

        System.out.println("In setup");
        for(int i=0; i < 1000; ++i) {
            l.add(new inner(i));
        }

        // Note that return value is List not UnmodifiableList
        List<inner> ul = Collections.unmodifiableList(l);
        ul.get(0).setI(2);
        assert(ul.get(0).getI() == 2);

        try {
            ul.add(new inner(1001));
        }
        catch( Exception e) {
            System.out.println(e.toString());
            assertEquals("caught exception", true, true);
        }
    }
}
