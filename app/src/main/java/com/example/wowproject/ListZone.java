package com.example.wowproject;

import java.util.ArrayList;
import java.util.List;

public class ListZone {

    private String name;
    private Integer id ;
    private String imageUrl;
    private ArrayList<ListEncounters> encounters;


    public String getName() {
        return name;
    }
    public Integer getId() {
        return id;
    }
    public String getImageUrl(){
        return imageUrl;
    }

    public ArrayList<ListEncounters> getEncounters() {
        return encounters;
    }
}
