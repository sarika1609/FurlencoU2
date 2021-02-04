package com.example.furlenco.Listners;

import com.example.furlenco.ModelClasses.CartModelClass;

import java.util.List;

public interface AddCartListner {
    void onItemClicked(List<CartModelClass> cartModelClassList);
}
