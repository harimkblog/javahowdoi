package com.javahowdoi.string;

import org.apache.commons.lang3.StringUtils;

import static junit.framework.TestCase.*;

/**
 * Created by Hari on 1/5/2020.
 */
public class SearchDemo {
    public static void main(String[] args) {
        String  s = "Pennsylvania";
        String s1 = "van";
        String s2 = "Van";

        assertEquals( "indexOf equals 7", 7, s.indexOf(s1) );
        assertTrue("contains match ", s.contains(s1));
        assertFalse("contains don't match ", s.contains(s2));
        assertTrue("containsIgnoreCase match ", StringUtils.containsIgnoreCase(s, s2));
        assertTrue("containsAny match ", StringUtils.containsAny(s, s1, s2));
    }
}
