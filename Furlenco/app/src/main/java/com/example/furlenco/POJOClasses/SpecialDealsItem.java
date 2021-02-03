package com.example.furlenco.POJOClasses;

import com.google.gson.annotations.SerializedName;

public class SpecialDealsItem{

	@SerializedName("data")
	private String data;

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public String getData(){
		return data;
	}

	public String getName(){
		return name;
	}

	public String getUrl(){
		return url;
	}
}