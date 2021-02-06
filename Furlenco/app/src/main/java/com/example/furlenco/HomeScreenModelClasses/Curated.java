package com.example.furlenco.HomeScreenModelClasses;

public class Curated {
    public static final int ITEM_TYPE_IMAGE = 0;
    public static final int ITEM_TYPE_DESC = 1;

    private int image;
    private String headerText;
    private String data;
    private int viewType;

    public Curated(int image, String headerText, String data, int viewType) {
        this.image = image;
        this.headerText = headerText;
        this.data = data;
        this.viewType = viewType;
    }

    public int getImage() {
        return image;
    }

    public String getHeaderText() {
        return headerText;
    }

    public String getData() {
        return data;
    }

    public int getViewType() {
        return viewType;
    }
}
