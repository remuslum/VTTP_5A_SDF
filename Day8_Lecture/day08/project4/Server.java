package day08.project4;

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

public class Server {
    public static void main(String[] args) throws IOException{
        int port = 3000;
        if(args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        ServerSocket server = new ServerSocket(port);
        Parser parser = new Parser();

        System.out.println("Awaiting connection from client");
        boolean serverRunning = true;
        while(serverRunning) {
            Socket connection = server.accept();

            System.out.println("Got a client connection");

            // Get input from client
            InputStream inputFromClient = connection.getInputStream();
            Reader reader = new InputStreamReader(inputFromClient);
            BufferedReader br = new BufferedReader(reader);

            // Send output to client
            OutputStream outputToClient = connection.getOutputStream();
            Writer writer = new OutputStreamWriter(outputToClient);
            BufferedWriter bw = new BufferedWriter(writer);

            String clientMessage = "";
            while ((clientMessage = br.readLine()) != null){
                String messageToServer = "";
                System.out.println("Msg from client: " + clientMessage);
                if (clientMessage.contains("exit")) {
                    messageToServer = "bye bye \n";
                    bw.write(messageToServer);
                    bw.flush();
                    break;
                } else {
                    //Read message from client
                    try {
                        String validMessage = parser.checkVaildArguments(clientMessage);
                        messageToServer = parser.parse(validMessage);
                    } catch (NumberFormatException e) {
                        messageToServer = "Invalid arguments, please only put numbers \n";
                    }
                }
                bw.write(messageToServer);
                bw.flush();
            }
            br.close();
            bw.close();
            connection.close();
            System.out.println("Client connection closed");
            serverRunning = !serverRunning;
        }
        System.out.println("Shutting down server");
        server.close();
        System.out.println("Server has been shut down");
    }
}
