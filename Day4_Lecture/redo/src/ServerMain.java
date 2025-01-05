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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerMain {
    public static void main(String[] args) throws IOException{
        int port = 3000;

        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        ServerSocket socket = new ServerSocket(port);

        while (true) {
            System.out.println("Awaiting connection from client");

            Socket connection = socket.accept();

            System.out.println("Got a client connection");

            // Get input from client
            InputStream inputFromClient = connection.getInputStream();
            Reader reader = new InputStreamReader(inputFromClient);
            BufferedReader br = new BufferedReader(reader);

            // Send output to client
            OutputStream outputToClient = connection.getOutputStream();
            Writer writer = new OutputStreamWriter(outputToClient);
            BufferedWriter bw = new BufferedWriter(writer);

            // Read message from client
            String clientMessage = br.readLine();
            System.out.printf(">>> Msg From Client: %s \n", clientMessage);

            // Write message to client
            String messageToClient = "Today's date is %s \n".formatted(new Date().toString());
            bw.write(messageToClient);
            bw.flush();
            bw.close();

            // Always remember to close the connection
            connection.close();
        }
    }
}