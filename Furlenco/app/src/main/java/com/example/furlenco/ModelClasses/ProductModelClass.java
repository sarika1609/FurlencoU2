package com.example.furlenco.ModelClasses;

public class ProductModelClass {
    String name;
    String image_url;

    public ProductModelClass(String name, String image_url) {
        this.name = name;
        this.image_url = image_url;
    }

    public String getName() {
        return name;
    }

    public String getImage_url() {
        return image_url;
    }
}
