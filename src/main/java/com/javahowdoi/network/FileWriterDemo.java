package com.javahowdoi.network;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class FileWriterDemo {
    private static void  writeToFile(String str) throws IOException {
        try( FileWriter fw = new FileWriter("C:/Users/Harim/work/tmp.txt") ) {
            fw.write(str + "\n");
        }
    }

    private static void  printToFile(String str) throws IOException {
        try( PrintWriter pw = new PrintWriter( new FileWriter("C:/Users/Harim/work/print.txt", true)) ) {
            pw.format( "Hello %s \n", str );
        }
    }

    private static void  bufferWrite(String str) throws IOException {
        try( BufferedWriter bw = new BufferedWriter( new FileWriter("C:/Users/Harim/work/buf.txt", true)) ) {
            bw.write( "Hello " + str + "\n" );
        }
    }

    public static void main(String[] args) throws IOException {
        // write in append mode
        writeToFile("hello 1");
        writeToFile("hello 2");
        writeToFile("hello 3");

        Path p = Paths.get("C:/Users/Harim/work/tmp.txt");
        Files.lines(p).forEach(System.out::println);

        printToFile("world");
        printToFile("US");

        p = Paths.get("C:/Users/Harim/work/print.txt");
        Files.lines(p).forEach(System.out::println);
    }
}
