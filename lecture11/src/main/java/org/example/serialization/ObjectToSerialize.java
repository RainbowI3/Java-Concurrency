package org.example.serialization;



import java.io.Serializable;
import java.util.Arrays;

/**
 * User: Dmitriy Kinoshenko
 * Date: 26.10.13
 */
public class ObjectToSerialize implements Serializable {

//    NotSerializable ns = new NotSerializable();

    public ObjectToSerialize(String strVal, int intVal, double[] arrVal) {
        this.strVal = strVal;
        this.intVal = intVal;
        this.arrVal = arrVal;
    }

    String strVal;
    int intVal;
    double[] arrVal;

    public String getStrVal() {
        return strVal;
    }

    public int getIntVal() {
        return intVal;
    }

    public double[] getArrVal() {
        return arrVal;
    }

    public void setStrVal(String strVal) {
        this.strVal = strVal;
    }

    public void setIntVal(int intVal) {
        this.intVal = intVal;
    }

    public void setArrVal(double[] arrVal) {
        this.arrVal = arrVal;
    }

    @Override
    public String toString() {
        return "strVal: " + strVal + ", intVal: " + intVal +
                ", arrVal: " + Arrays.toString(arrVal);
    }
}

class NotSerializable {

}
