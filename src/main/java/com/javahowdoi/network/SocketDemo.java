package com.javahowdoi.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Hari on 2/23/2020.
 */
public class SocketDemo {
        public static class Server implements AutoCloseable{
            private ServerSocket serverSocket;
            private Socket clientSocket;
            private PrintWriter out;
            private BufferedReader in;

            public void read(int port) throws IOException {
                serverSocket = new ServerSocket(port);
                clientSocket = serverSocket.accept();
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String greeting = in.readLine();
                System.out.println(greeting);
                out.println("hello client");
            }

            public void close() throws IOException {
                in.close();
                out.close();
                clientSocket.close();
                serverSocket.close();
            }
        }

        public static class GreetClient implements AutoCloseable{
            private Socket clientSocket;
            private PrintWriter out;
            private BufferedReader in;

            public void connectAndSend(String ip, int port) throws IOException {
                clientSocket = new Socket(ip, port);
                out = new PrintWriter(clientSocket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println(sendAndReceiveMessage("hello server"));
            }

            private String sendAndReceiveMessage(String msg) throws IOException {
                out.println(msg);
                String resp = in.readLine();
                return resp;
            }

            public void close() throws IOException {
                in.close();
                out.close();
                clientSocket.close();
            }
        }
        public static void main(String[] args) throws Exception {
            ExecutorService es = Executors.newFixedThreadPool(2);
            es.submit( () ->  {
                try(Server s = new Server()){
                    s.read(6666);
                } catch(Exception e) {} }
            );
            Thread.sleep(1000);
            es.submit( () ->  {
                try(GreetClient s = new GreetClient()){
                    s.connectAndSend("localhost", 6666);
                } catch(Exception e) {} }
            );
            es.awaitTermination(1, TimeUnit.SECONDS);
            es.shutdown();
        }
}
