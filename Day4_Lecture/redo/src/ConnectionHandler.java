package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.util.Date;

public class ConnectionHandler implements Runnable {
    private final Socket connection;

    public ConnectionHandler(Socket connection) {
        this.connection = connection;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        try {
            InputStream is = connection.getInputStream();
            Reader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);

            OutputStream os = connection.getOutputStream();
            Writer writer = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(writer);

            String message = br.readLine();

            System.out.printf("[%s]>>> MSG from client: %s\n", name, message);

            message = "timestamp=%s, msg=%s \n".formatted(
                (new Date()).toString(), message.toUpperCase()
            );

            bw.write(message);
            bw.flush();

            connection.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
}
