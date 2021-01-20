package com.javahowdoi.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by Hari on 2/7/2020.
 */
public class FileStream {
    public static void main(String[] args ) throws Exception {
String fileName = "c://lines.txt";
//read file into stream, try-with-resources
try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
    stream.limit(10).forEach(System.out::println);
} catch (IOException e) {
    e.printStackTrace();
}

try(BufferedReader br = new BufferedReader(new FileReader("c://lines.txt"))) {
    int i = 1; String l;
    while (( l = br.readLine()) != null) {
        System.out.println(l);
        if (++i > 10) break;
    }
}
    }
}
