package com.example.furlenco.POJOClasses;

import com.google.gson.annotations.SerializedName;

public class AppliancesItem{

	@SerializedName("offer")
	private String offer;

	@SerializedName("Monthly Rental")
	private String monthlyRental;

	@SerializedName("win1")
	private Win1 win1;

	@SerializedName("price")
	private String price;

	@SerializedName("name")
	private String name;

	@SerializedName("image url")
	private String imageUrl;

	public String getOffer(){
		return offer;
	}

	public String getMonthlyRental(){
		return monthlyRental;
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
}