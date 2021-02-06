package com.example.furlenco.POJOClasses;

import com.google.gson.annotations.SerializedName;

public class JsonMember2WheelersItem{

    @SerializedName("offer")
    private String offer;

    @SerializedName("image url2")
    private String imageUrl2;

    @SerializedName("win1")
    private Win1 win1;

    @SerializedName("price")
    private String price;

    @SerializedName("name")
    private String name;

    @SerializedName("image url")
    private String imageUrl;

    @SerializedName("monthly rental")
    private String monthlyRental;

    public String getOffer(){
        return offer;
    }

    public String getImageUrl2(){
        return imageUrl2;
    }

    public Win1 getWin1(){
        return win1;
    }

    public String getPrice(){
        return price;
    }

    public String getName(){
        return name;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public String getMonthlyRental(){
        return monthlyRental;
    }
}