package com.javahowdoi.network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NIO2Demo {

    private static class ReadHandler implements CompletionHandler<Integer, Object> {
        private AsynchronousSocketChannel asc;
        private ByteBuffer b;

        public ReadHandler(AsynchronousSocketChannel asc, ByteBuffer b) {
            this.asc = asc;
            this.b = b;
        }

        @Override
        public void completed(Integer result, Object o) {
            try {
                if(result > 0 ) {
                    System.out.println("Server: " + new String( b.array() ) );
                    b.flip();
                    Future<Integer> f = asc.write(b); // echo message back
                    f.get(); // wait for the write to complete before clearing the buffer
                    b.clear();
                    asc.read(b, null, this); // ready to receive again
                }
                if(result == -1 ) {
                    System.out.println("Server: End of stream received");
                    asc.close();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
         }

        @Override
        public void failed(Throwable exc, Object o) {

        }

    }

    private static class AcceptHandler implements CompletionHandler<AsynchronousSocketChannel, Object> {
        private AsynchronousServerSocketChannel ssc;
        public AcceptHandler(AsynchronousServerSocketChannel ssc ) {
            this.ssc = ssc;
        }

        @Override
        public void completed(AsynchronousSocketChannel asc, Object o) {
            if (ssc.isOpen()){
                ssc.accept(null, this); // ready to accept again
            }

            if ((asc != null) && (asc.isOpen())) {
                ByteBuffer buffer = ByteBuffer.allocate(256);
                ReadHandler handler = new ReadHandler(asc, buffer);
                asc.read(buffer, null, handler);
            }
        }
        @Override
        public void failed(Throwable exc, Object attachment) {
            // process error
        }
    }

    private static class SServer
    {
        private AsynchronousChannelGroup g;
        public SServer(AsynchronousChannelGroup g) {
            this.g = g;
        }

        public  void startServer() throws IOException {
            // Create a thread pool that can be used for listening and reading messages
            AsynchronousServerSocketChannel ssc = AsynchronousServerSocketChannel.open(g);
            InetSocketAddress addr = new InetSocketAddress("localhost", 8000);
            // Binds the socket to a local address/port
            ssc.bind(addr);
            AcceptHandler ah = new AcceptHandler(ssc);
            ssc.accept(null, ah);
        }
    }


    private static class SClient implements AutoCloseable {
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
                client.read(buffer);
                System.out.println("Client: " + new String(buffer.array()));
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

    public static void main(String[] args ) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(5);
        // create a dummy task to ensure a dummy task is created.  this will keep server running
        es.submit(()-> System.out.println("Server: Starting socket listener"));
        AsynchronousChannelGroup g = AsynchronousChannelGroup.withThreadPool(es);
        SServer s = new SServer(g);
        s.startServer();
        try( SClient c = new SClient()) {
            c.sendMsg();
        }
        g.shutdown();
        es.shutdownNow();
    }
}
