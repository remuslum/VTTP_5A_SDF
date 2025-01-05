package src;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadedServerMain {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 10; i++){
            System.out.println(">>> Main: Creating thread: " + i);
            ClientThread thread = new ClientThread("Hi There " + i);
            threadPool.submit(thread);
        }
    }
}
