package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;

public class ClientMain {
    public static void main(String[] args) throws IOException{
        // Creates a connection to the server

        Socket socket = new Socket("localhost",Integer.parseInt(args[0]));

        System.out.println(">>> Connection to server created \n");

        Console console = System.console();
        String messageToServer = console.readLine("> ");

        // Output stream
        OutputStream outputToServer = socket.getOutputStream();
        Writer writer = new OutputStreamWriter(outputToServer);
        BufferedWriter bw = new BufferedWriter(writer);

        // Input stream
        InputStream inputFromServer = socket.getInputStream();
        Reader reader = new InputStreamReader(inputFromServer);
        BufferedReader br = new BufferedReader(reader);

        // Writes the message to the server
        bw.write(messageToServer + "\n");
        bw.flush();

        String messageFromServer = br.readLine();

        System.out.printf(">>> Msg From Server %s \n", messageFromServer);

        socket.close();

    }
}
