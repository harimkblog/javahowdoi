package com.javahowdoi.challengeq;

import java.util.Optional;

/**
 * Created by Hari on 1/12/2020.
 */
public class OptionalDemo {

    public static String greeting(boolean b) {
        if(b)
            return "Hello World!!!";
        else
            return null;
    }

    public static Optional<String> greeting2(boolean b) {
        if(b)
            return Optional.of("Hello World!!!");
        else
            return Optional.empty();
    }

    public static void main(String[] args ) {
        //System.out.println( greeting(true) );
        System.out.println(greeting2(true).orElse("null"));
        Optional<String> o = Optional.of("HW").map(l -> l.toLowerCase());
Optional<Optional<String>> o2 = Optional.of("HW").map(l -> Optional.of("hw"));
// flatten the Optional objects
Optional<String> o3 = Optional.of("HW").flatMap(l -> Optional.of("hw"));
        System.out.println(o.toString());
    }
}

/**
    Optional<String> os = Optional.ofNullable(greeting(true));
    assertEquals( "Greeting match", "Hello World!!!", os.orElse("default greeting"));
**/