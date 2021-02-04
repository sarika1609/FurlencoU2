package com.example.furlenco.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.furlenco.Activities.HomeActivity2;
import com.example.furlenco.Listners.AddCartListner;
import com.example.furlenco.Listners.CartCommunationListner;
import com.example.furlenco.ModelClasses.CartModelClass;
import com.example.furlenco.ModelClasses.ProductModelClass;
import com.example.furlenco.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AddCartFragment extends Fragment implements AddCartListner {
    Button btn_cart_amount, btn_add_cart;
    ImageView iv_cart_product;
    HomeActivity2 homeActivity2;
    List<CartModelClass> cartModelClassList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    private void initUI(View view) {
        iv_cart_product = view.findViewById(R.id.iv_cart_product);
        btn_cart_amount = view.findViewById(R.id.btn_cart_amount);
        btn_add_cart = view.findViewById(R.id.btn_add_cart);
        btn_add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItemToCart();
            }
        });

    }

    private void addItemToCart() {
        ProductModelClass productModelClass = new ProductModelClass(R.string.allen_bedroom, "https://assets.furlenco.com/image/upload/dpr_3.0,f_auto,q_auto/v1/furlenco-images-2/uploads/production/furniture_item/439/1440w_540c5895.jpg");
        cartModelClassList.add(new CartModelClass("Allen Bedroom", productModelClass.getImage_url(), "Allen Queen bed with 6 mattress-basic", 3, "Delivery in next 2 hours", "750/mo", 32.7, 135.5));
        sendDataToActivity(cartModelClassList);
        Log.d("Tag", cartModelClassList.toString());

    }

    public static AddCartFragment newInstance() {
        AddCartFragment fragment = new AddCartFragment();
        return fragment;
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        homeActivity2 = (HomeActivity2) context;
    }


    @Override
    public void onItemClicked(List<CartModelClass> cartModelClassList) {
        sendDataToActivity(cartModelClassList);
    }

    private void sendDataToActivity(List<CartModelClass> cartModelClassList) {
        if (homeActivity2!=null){
            homeActivity2.setCartData(cartModelClassList);
        }
    }
}