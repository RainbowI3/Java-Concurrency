package serialization;

import java.io.*;

/**
 * User: Dmitriy Kinoshenko
 * Date: 26.10.13
 */
public class SerializationHelper {

    public static void serializeObject(
            ObjectToSerialize obj
    ) {

        try {
            File file = new File("obj.ser");
            FileOutputStream fos = new FileOutputStream(file);

            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(obj);

            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ObjectToSerialize deserializeObject() {
        try {
            File file = new File("obj.ser");
            FileInputStream fis = new FileInputStream(file);

            ObjectInputStream ois = new ObjectInputStream(fis);

            Object o = ois.readObject();

            ois.close();

            if (o instanceof ObjectToSerialize) {
                return (ObjectToSerialize) o;
            } else {
                System.err.println("Not expected class");
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
/*        ObjectToSerialize obj = new ObjectToSerialize(
                "Some val",
                123,
                new double[] {
                        323.3,
                        234.2,
                        5545.111
                });
//        obj.setIntVal(123);
//        obj.setStrVal("Some val");
//        obj.setArrVal(new double[] {
//                323.3,
//                234.2,
//                5545.111
//        });
        serializeObject(obj);*/

        ObjectToSerialize objectToSerialize = deserializeObject();
        System.out.println(objectToSerialize);

    }
}
