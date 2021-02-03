package com.example.furlenco.POJOClasses;

import com.google.gson.annotations.SerializedName;

public class AwardWinningDesignsItem{

	@SerializedName("data")
	private String data;

	@SerializedName("year")
	private Integer year;

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public String getData(){
		return data;
	}

	public Integer getYear(){
		return year;
	}

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}
}