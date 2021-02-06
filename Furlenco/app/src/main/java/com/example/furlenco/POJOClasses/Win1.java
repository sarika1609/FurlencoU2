package com.example.furlenco.POJOClasses;

import com.google.gson.annotations.SerializedName;

public class Win1{

    @SerializedName("name")
    private String name;

    @SerializedName("image url")
    private String imageUrl;

    public String getName(){
        return name;
    }

    public String getImageUrl(){
        return imageUrl;
    }
}