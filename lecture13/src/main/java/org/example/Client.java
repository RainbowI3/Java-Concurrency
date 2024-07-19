package org.example;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {

        int port = 8085;

        System.out.println("Client is starting...");
        Socket socket;
        try {

            socket = new Socket(InetAddress.getLocalHost(),port);
        } catch (IOException e) {
            System.err.println("Failed to connect to the server to port " + port);
            return;
        }

        TimeUnit.SECONDS.sleep(2);


        try {
//            PrintStream ps = new PrintStream(socket.getOutputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            System.out.println("Sending data to the server ");
            //ps.println("Some command");
//            ps.print(5);
//            ps.flush();
            dos.writeUTF("Some command");
            dos.writeInt(5);

            BufferedInputStream is = new BufferedInputStream(socket.getInputStream());

            System.out.println("Reading data from the the server ");
            String obtainedString = new String(is.readAllBytes());
            System.out.println("Obtained from the server:  "  + obtainedString);

        } catch (IOException e) {
            System.err.println("Failed to send data to the server");
        }







        System.out.println("Client is about to exit");
    }
}