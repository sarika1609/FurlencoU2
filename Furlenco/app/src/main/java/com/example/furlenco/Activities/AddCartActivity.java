package com.example.furlenco.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.furlenco.CartPreferenceHelper;
import com.example.furlenco.DetailsIntentService;
import com.example.furlenco.Fragments.AddCartFragment;
import com.example.furlenco.ModelClasses.CartModelClass;
import com.example.furlenco.ModelClasses.ProductModelClass;
import com.example.furlenco.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class AddCartActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_cart_amount, btn_add_cart;
    ImageView iv_cart_product;
    TextView tv_cart_count;
    List<CartModelClass> cartModelClassList = new ArrayList<>();
    String name, url, price, rent, url2, win1_name, win2_name;
    ImageButton btnBack;
    ImageButton btnLike, btn_cart_count;
    ImageButton btnWin2, btnWin3;
    ImageView ivWin1, ivWin2;
    TextView tv_win2_name, tv_win1_name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cart);
        initUI();
    }

    private void initUI() {
        iv_cart_product = findViewById(R.id.ivImageInProductView);
        btn_cart_amount = findViewById(R.id.btn_cart_amount);
        btn_add_cart = findViewById(R.id.btn_add_cart);
        btnBack = findViewById(R.id.btnBack);
        btnLike = findViewById(R.id.btnLike);
        btn_cart_count = findViewById(R.id.btn_cart_count);
        tv_cart_count = findViewById(R.id.tv_cart_count);
        btnWin3 = findViewById(R.id.btnWin3);
        btnWin2 = findViewById(R.id.btnWin2);
        ivWin1 = findViewById(R.id.ivWin1);
        ivWin2 = findViewById(R.id.ivWin2);
        tv_win2_name = findViewById(R.id.tv_win2_name);
        tv_win1_name = findViewById(R.id.tv_win1_name);

        CartPreferenceHelper.getInstance(this);
        //fragmentManage=gets

        btn_add_cart.setOnClickListener(this);
        btnLike.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        getData();


    }

    private void getData() {
        if (getIntent() != null && getIntent().getExtras() != null) {
            name = getIntent().getExtras().getString("name");
            url = getIntent().getExtras().getString("url");
            price = getIntent().getStringExtra("price");
            rent = getIntent().getStringExtra("rent");
            win1_name = getIntent().getStringExtra("win1");
            win2_name = getIntent().getStringExtra("win2");
            url2 = getIntent().getStringExtra("url2");

        }
        tv_cart_count.setText(cartModelClassList.size() + "");

        if (url != null) {
            Glide.with(btnWin2).load(url).placeholder(R.drawable.loading).into(btnWin2);
            Glide.with(ivWin1).load(url).placeholder(R.drawable.loading).into(ivWin1);
            Glide.with(iv_cart_product).load(url).placeholder(R.drawable.loading).into(iv_cart_product);
        }
        if (win1_name != null) {
            tv_win1_name.setText(win1_name);
        }
        if (win2_name != null) {
            tv_win2_name.setText(win2_name);
        }

        if (url2 != null) {
            Glide.with(ivWin2).load(url2).placeholder(R.drawable.loading).into(ivWin2);
            Glide.with(btnWin3).load(url2).placeholder(R.drawable.loading).into(btnWin3);
        }

        if (rent != null) {
            btn_cart_amount.setText(rent);
        }

    }


    public <CartModelClass> void setList(String key, List<CartModelClass> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        CartPreferenceHelper.WriteString(key, json);
    }


    private void addItemToCart() {
        cartModelClassList.add(new CartModelClass(name, url, "Allen Queen bed with 6 mattress-basic", cartModelClassList.size(), "Delivery in next 2 hours", price, 32.7, 135.5));
        tv_cart_count.setText(cartModelClassList.size() + "");
        setList("data", cartModelClassList);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add_cart:
                addItemToCart();
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
        finish();
    }

    private void addtolikeCart() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(name);
        builder.setMessage("Added to your favorites");
        builder.setPositiveButton("OK", null);
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}