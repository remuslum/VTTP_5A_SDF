package src;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class FileUploadServer {
    public static void main(String[] args) throws IOException{
        int port = Integer.parseInt(args[0]);

        ServerSocket serverSocket = new ServerSocket(port);
        
        while (true) {
            System.out.println("Awaiting connection...");

            Socket connection = serverSocket.accept();

            System.out.println("Successful connection");

            // Get file from Output Stream
            InputStream is = connection.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            String fileName = dis.readUTF();
            Long fileSize = dis.readLong();

            // Create output file
            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            byte[] buff = new byte[2 * 1024];
            int bytesRead = 0;
            int bytesRecv = 0;
            int idx = 0;

            System.out.printf("Receiving file %s of size %d\n", fileName, fileSize);

            while (bytesRecv < fileSize) {
                bytesRead = dis.read(buff);
                bytesRecv += bytesRead;

                // Write to the output stream
                bos.write(buff, 0, bytesRead);

                System.out.printf("%d> %d Recv %d of %d\n", idx, bytesRead, bytesRecv, fileSize);
    idx++;
            }


        }        

    }
}
