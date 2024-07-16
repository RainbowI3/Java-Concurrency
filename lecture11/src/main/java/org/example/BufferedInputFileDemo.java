package org.example;
import java.io.*;
public class BufferedInputFileDemo {
    public static String read(String filename) throws IOException {
        try (FileReader fr = new FileReader(filename);
             BufferedReader in = new BufferedReader(fr)) {
            String s;
            StringBuilder sb = new StringBuilder();

            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }

            return sb.toString();
        }
    }

    public static void main(String[] args)
            throws IOException {
//        System.out.println("Hello");
        System.out.print(read("src/main/java/BufferedInputFileDemo.java"));
//        System.out.print(read("src/main/java/BasicFileOutput.java"));
    }

}
