package com.javahowdoi.string;

import org.apache.commons.lang3.StringUtils;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Hari on 1/5/2020.
 */
public class SearchDemo {
    public static void main(String[] args) {
        String  s = "Pennsylvania";
        String s1 = "van";
        String s2 = "Van";

        assertEquals( "indexOf equals 7", 7, s.indexOf(s1) );
        assertEquals( "contains match ", true, s.contains(s1) );
        assertEquals( "contains don't match ", false, s.contains(s2) );
        assertEquals( "containsIgnoreCase match ", true, StringUtils.containsIgnoreCase(s, s2) );
        assertEquals( "containsAny match ", true, StringUtils.containsAny(s, s1, s2) );
    }
}
