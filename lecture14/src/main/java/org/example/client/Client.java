package org.example.client;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by DimaK on 15.11.2014.
 */
class Client implements KeySendListener {

    private final Map<Character, Integer> keys = new ConcurrentHashMap<>();
    private long kickOffTimeMsec;

    //    private final static int SEND_TIMEOUT_MSEC = 2 * 60 * 1000; // 2 minutes
    private final static int SEND_TIMEOUT_MSEC = 10 * 1000; // 10 seconds
    private final static int SERVER_PORT = 8071;

    private final ReentrantLock workerLock;
    private final Condition workerCondition;

    @Override
    public void send() {
        workerLock.lock();
        try {
            workerCondition.signal();
        } finally {
            workerLock.unlock();
        }
    }

    private boolean timeExpired() {
        return (new Date().getTime() - kickOffTimeMsec) > SEND_TIMEOUT_MSEC;
    }

    Client() {
        workerLock = new ReentrantLock();
        workerCondition = workerLock.newCondition();

        new ClientFrame(keys, this).setVisible(true);
        new Thread(this::sendKeyPressedStat, "worker").start();
    }

    private void sendKeyPressedStat() {
        kickOffTimeMsec = new Date().getTime();

        while (true) {
            workerLock.lock();
            try {
                try {
                    workerCondition.await();
                } catch (InterruptedException e) {
                    System.out.println("Interrupted main thread");
                }
                // check time
                if (timeExpired()) {

                    if (keys.isEmpty()) {
                        System.out.println("No keys, nothing to send");
                        continue;
                    }

                    System.out.println("Sending keys information to the server");
                    printKeys(keys);

                    try {
                        sendKeysInfo();
                    } catch (IOException e) {
                        System.err.println("Failed to send keys info");
                    }

                    // clear case for future usage
                    keys.clear();
                    kickOffTimeMsec = new Date().getTime();

                } else {
                    System.out.println("Wait a bit...");
                }
            } finally {
                workerLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Client();
    }

    private static void printKeys(Map<Character, Integer> keys) {
        System.out.printf("Keys (%d):\n%s%n", keys.size(), keys);
    }

    private void sendKeysInfo() throws IOException {
        Socket s = new Socket(InetAddress.getLocalHost(), SERVER_PORT);

        DataOutputStream ds = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));

        ds.writeInt(keys.size());
        for (Map.Entry<Character, Integer> pair : keys.entrySet()) {
            ds.writeChar(pair.getKey());
            ds.writeInt(pair.getValue());
        }
        ds.flush();

    }

}