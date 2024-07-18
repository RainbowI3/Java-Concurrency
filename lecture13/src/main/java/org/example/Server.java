package org.example;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Server is starting...");


        try(ServerSocket serverSocket = new ServerSocket(8085)) {
            System.out.println("Waiting for the first client...");

              try {
                Socket socket = serverSocket.accept();
                System.out.println("Client is connected");

                  DataInputStream in = new DataInputStream(socket.getInputStream());
                    String s = in.readUTF();
//                  String s ="qwert";
                  int num = in.readInt();
                  System.out.println("Received a string '" + s + "' and a number " + num + " from the client");

//                System.out.println("Close client socket");
//                socket.close();

              } catch (IOException e) {
                  System.out.println("Exception occurred while exchanging tha data with client:" + e.getMessage());

           }
        } catch (IOException e) {
            System.out.println("Failed to open a socket at port 8085");
            System.exit(1);
            return;
        }



        System.out.println("Server is about to exit");
    }
}
