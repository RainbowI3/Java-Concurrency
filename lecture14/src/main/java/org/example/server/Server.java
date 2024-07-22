package org.example.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.emptyMap;

/**
 * Created by DimaK on 20.11.2014.
 */
class Server {

    private static int requestsCount = 0;
    private static final int SERVER_PORT = 8071;
    private final ServerFrame serverFrame;

    Server() throws IOException {
        System.out.println("Server is started");

        serverFrame = new ServerFrame(emptyMap());
        serverFrame.setVisible(true);

        ServerSocket serv = new ServerSocket(SERVER_PORT);
        while (true) {
            Socket sock = serv.accept();
            processRequest(sock);
            sock.close();
        }
    }

    private void processRequest(Socket sock) throws IOException {
        requestsCount++;
        System.out.println(String.format("Received %d client request", requestsCount));
        DataInputStream is = new DataInputStream(new BufferedInputStream(sock.getInputStream()));
        int count = is.readInt();
        Map<Character, Integer> keys = new HashMap<>();
        for (int i = 0; i < count; i++) {
            keys.put(is.readChar(), is.readInt());
        }
        sock.close();
        System.out.println(String.format("%d keys to depict", keys.size()));

        serverFrame.updateKeys(keys);
    }

    public static void main(String[] args) throws IOException {
        new Server();
    }
}
