package com.javahowdoi.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NIODemo {

    public static class SServer implements AutoCloseable
    {
        private Selector selector;
        private ServerSocketChannel ssc;

        private SocketChannel accept() throws IOException {
            SocketChannel clientConn;
            clientConn = ssc.accept();
            clientConn.configureBlocking(false);
            // register client connection with the selector
            // selector will now wait on data from the client
            clientConn.register(selector, SelectionKey.OP_READ);
            System.out.println("Server: Connection accepted " + clientConn.getLocalAddress().toString());
            return clientConn;
        }

        private void read(SelectionKey myKey) throws IOException {
            //System.out.println("Server: Reading..." );
            SocketChannel clientConn = (SocketChannel) myKey.channel();
            ByteBuffer buffer = ByteBuffer.allocate(256);
            int res = 256;
            while(res == 256) {
                res = clientConn.read(buffer);
                if (res == -1) { // end of stream
                    System.out.println("Server: end of stream received");
                    clientConn.close(); // close the channel and adds the channel to cancelled channel key
                } else
                    System.out.println("Server: received " + new String(buffer.array()) );
                buffer.clear();
            }
        }

        private void startServer() throws IOException {
            selector = Selector.open(); // selector is open here
            // ServerSocketChannel: selectable channel for stream-oriented listening sockets
            ssc = ServerSocketChannel.open();
            InetSocketAddress addr = new InetSocketAddress("localhost", 8000);
            // Binds the socket to a local address/port
            ssc.bind(addr);
            ssc.configureBlocking(false);

            int ops = ssc.validOps();
            ssc.register(selector, ops, null);
        }

        public void run() {
            try {
                startServer();
                while (!Thread.currentThread().isInterrupted()) { // interrupted when shutdown on executor service is called
                    // Waits for incoming connection requests or incoming data. blocking call
                    int count = selector.select();
                    if(count ==0) {
                        System.out.println("Server: No channels ready to read or accept. Thread interrupted??" );
                        continue;
                    }
                    // get socket channels ready for I/O operations
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> it = keys.iterator();
                    while (it.hasNext()) {
                        SelectionKey myKey = it.next();
                        if (myKey.isAcceptable()) // received new connection request
                            accept();
                        else if (myKey.isReadable()) // received data from client
                            read(myKey);
                        it.remove();
                    }
                }
            } catch(Exception e) {
                System.out.println("Server: " + e.getMessage());
            }
        }

        @Override
        public void close() throws Exception {
            if(selector != null )
                selector.close();
            if(ssc != null )
                ssc.close();
        }
    }

    public static class SClient implements AutoCloseable {
        private SocketChannel client;
        private static final String greeting = "Hello World";
        // connect to server and send message
        public void sendMsg() {
            try {
                InetSocketAddress addr = new InetSocketAddress("localhost", 8000);
                client = SocketChannel.open(addr); // connect to server
                ByteBuffer buffer = ByteBuffer.wrap(greeting.getBytes());
                client.write(buffer);
                buffer.clear();
            } catch(Exception e) {
                System.out.println("Client: " + e.getMessage());
            } finally {
                if(client != null ) {
                    try {
                        System.out.println("Client: Closing connection");
                        client.close();
                    } catch(Exception e) {}
                }
            }
        }

        @Override
        public void close() throws Exception {
            if(client != null )
                client.close();
        }
    }

    public static void main(String[] args ) throws InterruptedException{
        ExecutorService es = Executors.newFixedThreadPool(2);
        // start server
        es.submit( () ->  {
            try(SServer s = new SServer()){
                s.run();
            } catch(Exception e) {} }
        );
        Thread.sleep(2000);
        es.submit( () ->  {
            try(SClient s = new SClient()){
                s.sendMsg();
            } catch(Exception e) {} }
        );
        Thread.sleep(2000);
        es.shutdownNow(); // interrupt running SServer thread
    }
}
