package com.javahowdoi.string;

import org.apache.commons.lang3.StringUtils;

import java.util.StringJoiner;

import static junit.framework.TestCase.*;

/**
 * Created by Hari on 1/4/2020.
 */
public class ConcatDemo {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";

        // Option I
        String s3 = s1 + s2;
        assertEquals("helloworld match", "helloworld", s3 );

        // Option II
        StringBuilder sb = new StringBuilder(32);
        s3 = sb.append(s1).append(s2).toString();
        assertEquals("helloworld match", "helloworld", s3 );

        // Option III
        StringBuffer sb1 = new StringBuffer();
        s3 = sb1.append(s1).append(s2).toString();
        assertEquals("helloworld match", "helloworld", s3 );

        // Option IV
        s3 = s1.concat(s2);
        assertEquals("helloworld match", "helloworld", s3 );

        // Option V
        s3 = String.join("", s1, s2);
        String[] l = {s1, s2};
        assertEquals("helloworld match", "helloworld", s3 );

        // Option VI
        StringJoiner j = new StringJoiner("", s1, s2);
        s3 = j.toString();
        assertEquals("helloworld match", "helloworld", s3 );

        String s = "";
        if( s != null && s.equals(""))
            System.out.println("");

        s = "";
        assertTrue("Empty check", StringUtils.isEmpty(s));
        s=null;
        assertTrue("Null check", StringUtils.isEmpty(s));
        s =" ";
        assertFalse("Blank check false", StringUtils.isEmpty(s));
        assertTrue("Blank check true", StringUtils.isBlank(s));
    }
}
