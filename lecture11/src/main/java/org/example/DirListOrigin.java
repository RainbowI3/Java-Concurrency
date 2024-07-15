package org.example;
//: io/DirList.java
// Display a directory listing using regular expressions.
// {Args: "D.*\.java"}

import java.util.regex.*;
import java.io.*;
import java.util.*;
public class DirListOrigin {
    public static void main(String[] args) {
        File path = new File("src");

        List<String> list = new ArrayList<String>();
        FilenameFilter filter;
        if (args.length == 0)
            filter = null;
        else
            filter = new DirFilterOrigin(args[0]);

        findFiles(path, filter, list);

        Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);

    }

    private static void findFiles(File parentFile, FilenameFilter filter, List<String> fileNames) {

        System.out.println("findFiles() is called, directory " + parentFile.getAbsolutePath());

        String[] childNames = parentFile.list();
        for (String childName : childNames) {
            File childFile = new File(parentFile, childName);

            if (childFile.isDirectory()) {
                findFiles(childFile, filter, fileNames);
            } else {
                if (filter == null || filter.accept(parentFile, childName))
                    fileNames.add(childName);
            }
        }
    }
}

class DirFilterOrigin implements FilenameFilter {
    private Pattern pattern;

    public DirFilterOrigin(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
