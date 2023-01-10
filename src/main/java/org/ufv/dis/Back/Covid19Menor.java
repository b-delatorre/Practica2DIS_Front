package org.ufv.dis.Back;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Covid19Menor {
    private ArrayList<Data> data = new ArrayList<>();

    public Covid19Menor(ArrayList<Data> data) {
        this.data = data;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }
}
