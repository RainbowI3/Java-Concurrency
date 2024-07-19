package org.example;

import java.io.Serializable;

public class ClientToServer implements Serializable {
    private String str;
    private transient int num;

    public ClientToServer(String str,int num) {
        this.str = str;
        this.num = num;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
