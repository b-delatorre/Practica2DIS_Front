package org.ufv.dis.Front;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Covid19Mayor {
    List<DataMayor> data;

    public Covid19Mayor(List<DataMayor> data) {
        this.data = data;
    }

    public List<DataMayor> getData() {
        return data;
    }

    public void setData(List<DataMayor> data) {
        this.data = data;
    }
}
