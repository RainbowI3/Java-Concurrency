package org.example;
import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        StringBuilder sb = new StringBuilder();
        List<int[]> coords =  List.of(
                new int[]{1,23},
                new int[]{231,245}
        );
        for(int[]coord : coords){
            sb
                    .append(coord[0])
                    .append(",")
                    .append(coord[1])
                    .append(";");
        }
        System.out.println("coords[0] = " + Arrays.toString(coords.get(0)));
        String coordsAsString = coords.toString();
        System.out.println("coords = "+ coordsAsString);

        System.out.println(sb);

        try{
            List<int[]> obtainedCoords = deserializeCoords("obj.ser");
            System.out.println("obtainedCoords = "+ obtainedCoords);
            System.out.println("obtainedCoords[" + obtainedCoords.size() +"]: ["
        +Arrays.toString(obtainedCoords.get(0)) + ","
           + Arrays.toString(obtainedCoords.get(1)) +"]"
            );
        }catch (IOException | ClassNotFoundException e){
            throw new RuntimeException(e);
        }
    }
    private static  List<int[]> deserializeCoords(String fileName) throws IOException,ClassNotFoundException{
        File file = new File(fileName);
        try(FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis)){
         return (List<int[]> ) ois.readObject();
        }
    }
    public static  void serializeCoords(List<int[]> coords,String fileName) throws IOException{
        File file = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(coords);
        }
    }
}