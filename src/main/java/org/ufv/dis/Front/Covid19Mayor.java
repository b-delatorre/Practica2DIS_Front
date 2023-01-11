package org.ufv.dis.Front;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Covid19Mayor {
    ArrayList<DataMayor> data;

    public Covid19Mayor(ArrayList<DataMayor> data) {
        this.data = data;
    }

    public ArrayList<DataMayor> getData() {
        return data;
    }

    public void setData(ArrayList<DataMayor> data) {
        this.data = data;
    }
}
