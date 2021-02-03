package com.example.furlenco.POJOClasses;

import com.google.gson.annotations.SerializedName;

public class FullHomeItem{

    @SerializedName("offer")
    private String offer;

    @SerializedName("win3")
    private Win3 win3;

    @SerializedName("image url2")
    private String imageUrl2;

    @SerializedName("win2")
    private Win2 win2;

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

    @SerializedName("win4")
    private Win4 win4;

    public String getOffer(){
        return offer;
    }

    public Win3 getWin3(){
        return win3;
    }

    public String getImageUrl2(){
        return imageUrl2;
    }

    public Win2 getWin2(){
        return win2;
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

    public Win4 getWin4(){
        return win4;
    }
}