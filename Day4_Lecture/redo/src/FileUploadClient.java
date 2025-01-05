package src;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class FileUploadClient {
    public static void main(String[] args) throws IOException{
        String[] port = args[0].split(":");
        String portName = port[0];
        int host = Integer.parseInt(port[1]);
        Socket socket = new Socket(portName, host);
        System.out.println("Connected to client");
        
        String dirPath = args[1];
        String fileName = args[2];
        File file = new File(dirPath + File.separator + fileName);

        // Open the file for reading 
        FileInputStream fileInput = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fileInput);

        // Create an output stream to the server
        OutputStream toServer = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(toServer);

        // Write to output stream the file name and size for the server
        dos.writeUTF(file.getName());
        dos.writeLong(file.length());

        byte[] buff = new byte[4 * 1024];
        int bytesRead = 0;
        int totalBytesRead = 0;
        int idx = 0;

        while((bytesRead = bis.read(buff)) > 0) {
            dos.write(buff, 0, bytesRead);
            totalBytesRead += bytesRead;
            idx++;
            System.out.printf("%d > %d Send %d of %d\n", idx, bytesRead, totalBytesRead, file.length());
        }

        bis.close();
        dos.flush();
        dos.close();
        socket.close();
    }
}
