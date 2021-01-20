package com.javahowdoi.util;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.SerializationUtils;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Hari on 2/22/2020.
 */
public class Util {

    public static void main(String[] args) {
        //int hc = Objects.hashCode("hello");
        int hc = Objects.hash("a1","a2","a3","a4");
        System.out.println(hc);

        ArrayList<Integer> ai = new ArrayList<>();
        ai.hashCode();

        List<String> l = Arrays.asList("a1","a2","a3","a4");
        int hc2 = l.hashCode();
        assertEquals("hashcode equals", hc, hc2);

        int[] ia = {1,2,3,4};
        int[] iac3 = SerializationUtils.clone(ia);
        assertEquals( "Equals check", true, Arrays.equals(ia, iac3));
        assertEquals( "Equals check", false, ia.equals(iac3));

        int[] iac2 = Arrays.copyOf(ia, ia.length);
        assertEquals( "Equals check", true, Arrays.equals(ia, iac2));

        int[] iac = {101,102,103,104};
        System.arraycopy(ia, 0, iac, 0, ia.length);
        assertEquals( "Equals check", true, Arrays.equals(ia, iac));


        int[] iad = {1,2,3,4};
        assertEquals( "Equals check", true, Arrays.equals(ia, iad));
        int[] iae = ia;
        assertEquals( "Equals check", true, ia.equals(iae));
        assertEquals( "Not Equals check", false, ia.equals(iad));

        Integer[] io = {1,2,3,4};
        Integer[] io2 = Arrays.stream(io).toArray(Integer[]::new);
        assertEquals( "Equals check", true, Arrays.equals(io, io2));

        Integer[] IA = ArrayUtils.toObject(ia);
        int[] ia3 = ArrayUtils.toPrimitive(IA);
        List<Integer> li = Arrays.asList(1,2,3,4);
        assertEquals("HC equals", Arrays.hashCode(ia), li.hashCode());

        int i = -2, j = 2;
        System.out.println( i >> 1 );
        System.out.println( i );
        System.out.println( i >>> 1 );
        System.out.println( i );

        System.out.println( 2 ^ 3 );
        int[] ia2 = ArrayUtils.remove(ia, 2);
        System.out.println(ia2.length);

        List<Integer> li2 = new ArrayList<>();
        Collections.addAll(li2, IA);
    }
}
