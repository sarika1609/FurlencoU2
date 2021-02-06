package com.example.furlenco.HomeScreenModelClasses;

public class BrowseCollections {
    private int image;
    private String tag;

    public BrowseCollections(int image, String tag) {
        this.image = image;
        this.tag = tag;
    }

    public int getImage() {
        return image;
    }

    public String getTag() {
        return tag;
    }
}
