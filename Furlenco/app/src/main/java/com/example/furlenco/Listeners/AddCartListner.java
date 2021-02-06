package com.example.furlenco.Listeners;

import com.example.furlenco.ModelClasses.CartModelClass;

import java.util.List;

public interface AddCartListner {
    void onItemClicked(List<CartModelClass> cartModelClassList);
}
