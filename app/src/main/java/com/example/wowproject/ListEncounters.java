package com.example.wowproject;

import java.io.Serializable;
import java.util.List;

public class ListEncounters implements  Serializable{

    private String name;
    private Integer id ;
    private String imageUrl;


    public String getName() {
        return name;
    }
    public Integer getId() {
        return id;
    }
    public String getImageUrl(){
        return imageUrl;

    }
}
