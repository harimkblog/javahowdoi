package com.javahowdoi.string;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Hari on 1/11/2020.
 */
public class InternDemo {

    public static void main(String[] args) {
String s = new String("abc");
String s1 = new String("abc");

assertEquals("Reference inequality", false, s==s1);
assertEquals("String equality", true, s.equals(s1));

String s2 = new String("abcd").intern();
String s3 = new String("abcd").intern();
assertEquals("Reference equality", true, s2==s3);
    }
}
