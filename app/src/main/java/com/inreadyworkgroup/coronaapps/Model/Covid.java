package com.inreadyworkgroup.coronaapps.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Covid {
    private String single;

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("total_terkonfirmasi")
    @Expose
    private String positif;

    @SerializedName("total_sembuh")
    @Expose
    private String sembuh;

    @SerializedName("total_meninggal")
    @Expose
    private String meninggal;

    @SerializedName("dirawat")
    @Expose
    private String dirawat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositif() {
        return positif;
    }

    public void setPositif(String positif) {
        this.positif = positif;
    }

    public String getSembuh() {
        return sembuh;
    }

    public void setSembuh(String sembuh) {
        this.sembuh = sembuh;
    }

    public String getMeninggal() {
        return meninggal;
    }

    public void setMeninggal(String meninggal) {
        this.meninggal = meninggal;
    }

    public String getDirawat() {
        return dirawat;
    }

    public void setDirawat(String dirawat) {
        this.dirawat = dirawat;
    }
}
