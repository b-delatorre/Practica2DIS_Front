package org.ufv.dis.Back;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Data {
    @SerializedName(value = "codigo_geometria", alternate = "cod")
    private String cod;
    @SerializedName(value = "zona_basica_salud", alternate = "zona")
    private String zona;
    @SerializedName(value = "tasa_incidencia_acumulada_ultimos_14dias", alternate = "tasa14")
    private float tasa14;
    @SerializedName(value = "tasa_incidencia_acumulada_total", alternate = "tasaTotal")
    private float tasaTotal;
    @SerializedName(value = "casos_confirmados_totales", alternate = "casos")
    private int casos;
    @SerializedName(value = "fecha_informe", alternate = "fecha")
    private String fecha;

    public Data(String cod, String zona, float tasa14, float tasaTotal, int casos, String fecha) {
        this.cod = cod;
        this.zona = zona;
        this.tasa14 = tasa14;
        this.tasaTotal = tasaTotal;
        this.casos = casos;
        this.fecha = fecha;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public float getTasa14() {
        return tasa14;
    }

    public void setTasa14(float tasa14) {
        this.tasa14 = tasa14;
    }

    public float getTasaTotal() {
        return tasaTotal;
    }

    public void setTasaTotal(float tasaTotal) {
        this.tasaTotal = tasaTotal;
    }

    public int getCasos() {
        return casos;
    }

    public void setCasos(int casos) {
        this.casos = casos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
