package com.javahowdoi.string;

import static junit.framework.TestCase.*;

/**
 * Created by Hari on 1/11/2020.
 */
public class InternDemo {

    public static void main(String[] args) {
        String s = new String("abc");
        String s1 = new String("abc");

        assertFalse("Reference inequality", s == s1);
        assertTrue("String equality", s.equals(s1));

        String s2 = new String("abcd").intern();
        String s3 = new String("abcd").intern();
        assertTrue("Reference equality", s2 == s3);
    }
}
