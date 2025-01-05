package src;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedServerSocketMain {
    public static void main(String[] args) throws IOException{
        int port = 3000;

        if (args.length > 0){
            port = Integer.parseInt(args[0]);
        }

        String name = Thread.currentThread().getName();

        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        ServerSocket server = new ServerSocket(port);

        System.out.println(">>> LIstening on port " + port);

        int connections = 0;

        while (true) { 
            System.out.printf("[%s] %d Waiting for connection\n", name, connections);
            connections++;

            // Wait for incoming connection, block
            Socket conn = server.accept();

            System.out.printf("[%s] Got a client connection\n", name);

            // Create a connection handler with the client socket
            ConnectionHandler handler = new ConnectionHandler(conn);

            // Pass the handler (work) to the thread pool
            threadPool.submit(handler);

            System.out.printf("[%s] Submiited connection handler to thread pool\n", name);
        }
    }


}
