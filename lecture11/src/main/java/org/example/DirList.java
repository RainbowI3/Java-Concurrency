package org.example;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class DirList {
    public static void main(String[] args) {
        File path = new File("src");
        if (!path.exists()) {
            System.err.println("Does not exist, aborting");
            return;
        }
        if (!path.isDirectory()) {
            System.err.println("Is not a directory, aborting");
            return;
        }

        FilenameFilter filter;
        if (args.length == 0)
            filter = null;
        else
            filter = new DirFilter(args[0]);

        List<String> fileNames = new ArrayList<String>();
        listFiles(fileNames, path, filter);

//        Collections.sort(fileNames, String.CASE_INSENSITIVE_ORDER);
//        for (String dirItem : fileNames)
//            System.out.println(dirItem);

        fileNames.stream().sorted().forEach(System.out::println);
    }

    private static void listFiles(List<String> fileNames, File currPath, FilenameFilter filter) {
        String[] list;
        list = currPath.list();
        for (String childFileName : list) {
            if (filter != null && !filter.accept(currPath, childFileName)) {
                continue;
            }

            File childFile = new File(currPath, childFileName);

            if (childFile.isFile()) {
                fileNames.add(currPath.getAbsolutePath() + "/" + childFileName);
            } else {
                listFiles(fileNames, childFile, filter);
            }

        }

    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    public boolean accept(File dir, String name) {
        return new File(dir, name).isDirectory() ||
                pattern.matcher(name).matches();
    }

}
