package com.example.furlenco.HomeScreenModelClasses;

public class Design {

    public static final int ITEM_TYPE_IMAGE = 0;
    public static final int ITEM_TYPE_DESC = 1;
    public static final int ITEM_TYPE_EXAMPLE = 2;

    private int image;
    private String headerText;
    private String data;
    private int viewType;

    public Design(int image, String headerText, String data, int viewType) {
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
