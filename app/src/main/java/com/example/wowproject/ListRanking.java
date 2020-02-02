package com.example.wowproject;

import com.google.gson.annotations.SerializedName;

public class ListRanking {

    private String name;
    @SerializedName("class")
    private float classe;
    private float spec;
    private String guild;
    private String server;
    private String region;
    private double duration;
    private double damagetaken;
    private double deaths;
    private double itemLevel;
    private double patch;
    private long size;

    public String getName() {
        return name;
    }

    public float getClasse() {
        return classe;
    }

    public double getTotal() { return total; }

    public float getSpec() {
        return spec;
    }

    public String getGuild() {
        return guild;
    }

    public String getServer() {
        return server;
    }

    public String getRegion() {
        return region;
    }

    public double getDuration() {
        return duration;
    }

    public double getDamagetaken() {
        return damagetaken;
    }

    public double getDeaths() {
        return deaths;
    }

    public double getItemLevel() {
        return itemLevel;
    }

    public double getPatch() {
        return patch;
    }

    public long getSize() {
        return size;
    }

    private double total;

}
