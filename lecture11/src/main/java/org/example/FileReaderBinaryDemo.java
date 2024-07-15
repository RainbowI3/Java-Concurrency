package org.example;

/**
 * User: Dmitriy Kinoshenko
 * Date: 26.10.13
 */

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderBinaryDemo {

    //
    private static final int BUF_SIZE = 4;

    public static void main(String[] args) {
        File f = new File("test.txt");
        int b, count = 0;
        char[] buf = new char[BUF_SIZE];
        try {
            FileReader is = new FileReader(f);
            is.read();
//             FileInputStream is = new FileInputStream(f); //
            int read;
            while ((read = is.read(buf)) != -1) {
                System.out.print(buf);
//                if (read == BUF_SIZE)
//
//                    System.out.print(buf);
//                else {
//                    System.out.print(Arrays.copyOf(buf, read));
//                }
                count += read;
//                Arrays.fill(buf, ' ');
            }
            is.close();
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода: " + e);
        }
        System.out.print("\nПрочитано символов = " + count);
    }
}
