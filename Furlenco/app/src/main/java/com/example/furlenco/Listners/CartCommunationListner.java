package com.example.furlenco.Listners;

import com.example.furlenco.ModelClasses.CartModelClass;

import java.util.List;

public interface CartCommunationListner {
    void updateCartList(List<CartModelClass> cartModelClassList);
}
