package com.javahowdoi.string;

/**
 * Created by Hari on 1/9/2020.
 */
public class SwitchDemo {
    public static void main(String[] args) {
        String s = "1";

        if( s.equals("1"))
            System.out.println("One");
        else if (s.equals("2"))
            System.out.println("two");
        else
            System.out.println("some number");

        switch(s) {
            case "1":
                System.out.println("One");
                break;
            case "2":
                System.out.println("two");
                break;
            default:
                System.out.println("some number");
        }
    }
}
