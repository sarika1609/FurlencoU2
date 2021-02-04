package com.example.furlenco.ModelClasses;

public class CartModelClass {
    String name;
    String url;
    String description;
    int cart_count;
    String delivery_time;
    String price;
    Double discount;
    Double gst;

    public CartModelClass(String name, String url, String description, int cart_count, String delivery_time, String price, Double discount, Double gst) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.cart_count = cart_count;
        this.delivery_time = delivery_time;
        this.price = price;
        this.discount = discount;
        this.gst = gst;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public int getCart_count() {
        return cart_count;
    }

    public String getDelivery_time() {
        return delivery_time;
    }

    public String getPrice() {
        return price;
    }

    public Double getDiscount() {
        return discount;
    }

    public Double getGst() {
        return gst;
    }
}