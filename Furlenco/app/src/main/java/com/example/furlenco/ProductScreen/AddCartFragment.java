package com.example.furlenco.ProductScreen;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.furlenco.Activities.HomeActivity;
import com.example.furlenco.Interfaces.BedRoomCartCommunicationListner;
import com.example.furlenco.Listeners.AddCartListner;
import com.example.furlenco.ModelClasses.CartModelClass;
import com.example.furlenco.ModelClasses.ProductModelClass;
import com.example.furlenco.POJOClasses.BedroomItem;
import com.example.furlenco.R;

import java.util.ArrayList;
import java.util.List;


public class AddCartFragment extends Fragment implements AddCartListner, BedRoomCartCommunicationListner, View.OnClickListener {

    Button btn_cart_amount, btn_add_cart;
    ImageView iv_cart_product;
    HomeActivity homeActivity;
    TextView tv_cart_count;
    List<CartModelClass> cartModelClassList = new ArrayList<>();
    String name, url;
    ImageButton btnBack;
    ImageButton btnLike, btn_cart_count;
    FragmentManager fragmentManager;

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
        iv_cart_product = view.findViewById(R.id.ivImageInProductView);
        btn_cart_amount = view.findViewById(R.id.btn_cart_amount);
        btn_add_cart = view.findViewById(R.id.btn_add_cart);
        btnBack = view.findViewById(R.id.btnBack);
        btnLike = view.findViewById(R.id.btnLike);
        btn_cart_count = view.findViewById(R.id.btn_cart_count);
        tv_cart_count = view.findViewById(R.id.tv_cart_count);
        //fragmentManage=gets

        btn_add_cart.setOnClickListener(this);
        btnLike.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        getData();


    }

    private void getData() {
        if (getArguments() != null) {
            name = getArguments().getString("name");
            url = getArguments().getString("url");
        }
        tv_cart_count.setText(cartModelClassList.size()+"");
        if (url != null) {
            Glide.with(iv_cart_product).load(url).into(iv_cart_product);
        }
    }

    private void addItemToCart(String name, String url) {
        ProductModelClass productModelClass = new ProductModelClass(name, url);
        cartModelClassList.add(new CartModelClass(name, url, "Allen Queen bed with 6 mattress-basic", cartModelClassList.size(), "Delivery in next 2 hours", "750/mo", 32.7, 135.5));
        sendDataToActivity(cartModelClassList);
        Log.d("Tag", cartModelClassList.toString());
        tv_cart_count.setText(cartModelClassList.size() + 1 + "");

    }

    public static AddCartFragment newInstance() {
        AddCartFragment fragment = new AddCartFragment();
        fragment.onResume();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        homeActivity = (HomeActivity) context;
    }


    @Override
    public void onItemClicked(List<CartModelClass> cartModelClassList) {
        sendDataToActivity(cartModelClassList);
    }

    private void sendDataToActivity(List<CartModelClass> cartModelClassList) {
        if (homeActivity != null) {
            homeActivity.setCartData(cartModelClassList);
        }
    }

    @Override
    public void sendBedRoomCartDetails(BedroomItem bedroomItem) {
        if (bedroomItem != null) {
            name = bedroomItem.getName();
            url = bedroomItem.getImageUrl();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_cart:
                addItemToCart(name, url);
                break;
            case R.id.btnBack:
                gotoPreviousFragment();
                break;
            case R.id.btnLike:
                addtolikeCart();
                break;
        }
    }

    private void gotoPreviousFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AddCartFragment addCartFragment = new AddCartFragment();
        fragmentTransaction.remove(addCartFragment).commit();
    }

    private void addtolikeCart() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(name);
        builder.setMessage("Added to your favorites");
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}