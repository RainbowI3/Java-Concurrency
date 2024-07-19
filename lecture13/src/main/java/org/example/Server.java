package org.example;

import java.io.*;
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

//                  DataInputStream in = new DataInputStream(socket.getInputStream());
                  ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                  ClientToServer obj = (ClientToServer) in.readObject();

                    String s = obj.getStr();
//                  String s ="qwert";
                  int num = obj.getNum();
                  System.out.println("Received a string '" + s + "' and a number " + num + " from the client");


                  StringBuilder sb = new StringBuilder(s.length() * num);
                   for(int i = 0; i < num;i++){
                      sb.append(s);
                   }

                  System.out.println("Sending back a string to the client: " + sb);
                  BufferedOutputStream os =new BufferedOutputStream(socket.getOutputStream());
                   os.write(sb.toString().getBytes());
                   os.flush();
                   System.out.println("All data is sent");
                   socket.close();

              } catch (IOException |ClassNotFoundException e) {
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
