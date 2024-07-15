package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/FileInputStreamDemo.java");

        String s = readFileContent(file);

        // NIO2!
//        String s = new String(Files.readAllBytes(Paths.get("src/FileInputStreamDemo.java")));

        System.out.println("File content is:\n\n" + s);
    }

    /*
    aaabbbccc
    buf 2
    -> 2, [aa]
    -> 2, [ab]
    -> bb
    -> cc
    -> 1, [c]
    -> -1
*/
    private static String readFileContent(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.println("Total file size to read (in bytes) : "
                    + fis.available());

            StringBuilder result = new StringBuilder(fis.available());

            byte[] buf = new byte[256];
            int bytesRead;
            while ((bytesRead = fis.read(buf)) != -1) {
                System.out.println("\t++ " + bytesRead);
                result.append(new String(buf, 0, bytesRead));
//                result.append(new String(buf, 0, buf.length));
            }

            return result.toString();
        } catch (IOException e) {
            System.err.println("Failed to read content of file: " + e.getMessage());
            return null;
        }
    }

}
