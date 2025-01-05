package src;

public class ClientThread implements Runnable {
    private final String message;

    public ClientThread(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        System.out.printf("Thread name: %s, message: %s \n", threadName, message);
    }
     
}
