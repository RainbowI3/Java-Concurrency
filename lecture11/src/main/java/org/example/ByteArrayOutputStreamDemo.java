package org.example;
import java.io.*;
public class ByteArrayOutputStreamDemo {
    public static void main(String args[]) throws IOException {
        ByteArrayOutputStream f = new ByteArrayOutputStream();
        String s = "This should end up in the array";
//        byte buf[] = s.getBytes(Charset.forName("utf-16"));
        byte buf[] = s.getBytes();
        f.write(buf);
        System.out.println("Buffer as a string");
        System.out.println(f.toString());
        System.out.println("Into array");
        byte b[] = f.toByteArray();
        for (byte aB : b) {
            System.out.print((char) aB);
        }
        System.out.println("\nTo an OutputStream()");

        OutputStream f2 = new FileOutputStream("test.txt");
        f.writeTo(f2);
        f2.close();
        System.out.println("Doing a reset");
        f.reset();
        for (int i = 0; i < 3; i++) {
            f.write('X');
        }
        System.out.println(f.toString());
    }
}
