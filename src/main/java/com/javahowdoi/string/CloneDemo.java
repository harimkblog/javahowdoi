package com.javahowdoi.string;

import org.apache.commons.lang3.SerializationUtils;

import java.time.Instant;
import java.util.ArrayList;

import static junit.framework.TestCase.*;

/**
 * Created by Hari on 1/8/2020.
 */
public class CloneDemo {
    private static class Inner1 {
        public int i;
        public int j;

        Inner1(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if(! (o instanceof  Inner1 ))
                return false;
            Inner1 i1 = (Inner1) o;
            return (i1.i == this.i && i1.j == this.j );
        }
    }

    private static class Inner2 implements Cloneable{
        public String s;
        public Inner1 i1 = new Inner1(1,2);

        Inner2(String s ) {
            this.s = s;
        }

        @Override
        public Inner2 clone() {
            // create new Inner1 object
            // do not clone immutable string object
            return( new Inner2(this.s) );
        }

        @Override
        public boolean equals(Object o) {
            if(! (o instanceof  Inner2 ))
                return false;
            Inner2 i2 = (Inner2) o;
            return ( i2.s.equals(this.s) && i2.i1.equals(this.i1));
        }
    }


    public static void main(String[] args) {
        ArrayList<Instant> al = new ArrayList<>();
        for(int i=0; i<10; ++i)
            al.add(Instant.now());
        // deep copy for immutable and mutable objects
        ArrayList<Instant> al2 = SerializationUtils.clone(al);
        //shallow copy
        ArrayList<Instant> al3 = new ArrayList<>(al);
        for(int i=0; i<10; ++i) {
            assertTrue("Equals match", al2.get(i).equals(al.get(i)));
            assertTrue("Equals match", al3.get(i).equals(al.get(i)));
            assertFalse("Reference don't match", al2.get(i) == al.get(i));
            assertTrue("Equals match", al3.get(i) == al.get(i));
        }

        ArrayList<Inner2> ai = new ArrayList<>();
        for(int i=0; i<10; ++i)
            ai.add( new Inner2( new String("abc")));
        ArrayList<Inner2> ai2 = new ArrayList<>();
        // shallow copy for immutable objects
        // deep copy for mutable objects
        for(int i=0; i<10; ++i)
            ai2.add( ai.get(i).clone());

        for(int i=0; i<10; ++i) {
            assertTrue("Equals match", ai.get(i).equals(ai2.get(i)));
            assertFalse("Reference don't match for Inner1", ai.get(i).i1 == ai2.get(i).i1);
            assertTrue("Object reference matches for String", ai.get(i).s == ai2.get(i).s);
        }
    }
}
