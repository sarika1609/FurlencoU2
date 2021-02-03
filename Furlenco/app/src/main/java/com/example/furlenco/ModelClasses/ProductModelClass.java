package com.example.furlenco.ModelClasses;

public class ProductModelClass {
    int name;
    String image_url;

    public ProductModelClass(int name, String image_url) {
        this.name = name;
        this.image_url = image_url;
    }

    public int getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }
}
