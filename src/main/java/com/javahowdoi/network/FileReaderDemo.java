package com.javahowdoi.network;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Created by Hari on 7/4/2020.
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        System.out.println( Charset.defaultCharset().displayName() );
        File f = new File("c:/users/hari/test.txt");
        InputStreamReader is = new InputStreamReader(new FileInputStream(f), Charset.forName("UTF8") );
        //BufferedReader bf = new BufferedReader( is new FileReader()  );
        BufferedReader bf = new BufferedReader( is );
        bf.lines().forEach(System.out::println);
        System.out.println("=======");

        Path p = java.nio.file.Paths.get("c:/users/hari/test.txt");
        List<String> l = Files.readAllLines(p, Charset.defaultCharset());
        l.forEach(System.out::println);
        System.out.println("=======");

        Files.lines(p).forEach(System.out::println);
    }
}
