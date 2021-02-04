package com.example.furlenco.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.furlenco.Interfaces.OnProductClick;
import com.example.furlenco.Adapters.ProductsAdapter;
import com.example.furlenco.POJOClasses.ResponseModel;
import com.example.furlenco.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;

public class HomeActivity extends AppCompatActivity implements OnProductClick {
    RecyclerView rv_products, rv_collection;
    TextView tv_home, tv_products, tv_collection, tv_cart, tv_profile;
    ResponseModel responseModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initUI();
    }

    private void initUI() {
        rv_products = findViewById(R.id.rv_products);
        rv_collection = findViewById(R.id.rv_collection);
        tv_home = findViewById(R.id.tv_home);
        tv_products = findViewById(R.id.tv_products);
        tv_collection = findViewById(R.id.tv_collection);
        tv_cart = findViewById(R.id.tv_cart);
        tv_profile = findViewById(R.id.tv_profile);
        tv_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        tv_products.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ProductsActivity.class);
                startActivity(intent);
            }
        });

//        tv_collection.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeActivity.this, CollectionsActivity.class);
//                startActivity(intent);
//            }
//        });
//        tv_cart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeActivity.this, CartActivity.class);
//                startActivity(intent);
//            }
//        });
//        tv_profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
//                startActivity(intent);
//            }
//        });
        bindData();
    }

    private void bindData() {
       Thread thread = new Thread(apiRunnable);
       thread.start();
    }

    private Runnable apiRunnable = new Runnable() {
        @Override
        public void run() {
            getDataFromJson();
        }
    };

    private void getDataFromJson() {
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("response.json");
            int data = inputStream.read();
            StringBuffer stringBuffer = new StringBuffer();
            while (data != -1) {
                char ch = (char) data;
                stringBuffer.append(ch);
                data = inputStream.read();
            }

            buildPOJOFromJSON(stringBuffer.toString());

        } catch (Exception e) {
            Log.d("Tag", e.getMessage());
        }

    }

    private void buildPOJOFromJSON(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ResponseModel>() {
        }.getType();
        ResponseModel responseModel = gson.fromJson(json, type);
        setData(responseModel);
    }

    private void setData(ResponseModel responseModel) {
        this.responseModel = responseModel;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(HomeActivity.this, 3);
                rv_products.setLayoutManager(gridLayoutManager);
                ProductsAdapter productsAdapter = new ProductsAdapter(responseModel.getExploreProducts());
                rv_products.setAdapter(productsAdapter);
            }
        });
    }

    @Override
    public void productItemClicked(int position) {
        Intent intent = new Intent(HomeActivity.this, ProductsActivity.class);
        startActivity(intent);
    }
}