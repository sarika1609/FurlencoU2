package com.example.furlenco.HomeScreenFragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.Activities.HomeActivity2;
import com.example.furlenco.Adapters.ProductsAdapter;
import com.example.furlenco.Interfaces.OnProductClick;
import com.example.furlenco.POJOClasses.ResponseModel;
import com.example.furlenco.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;


public class HomeFragment extends Fragment implements OnProductClick {

    RecyclerView rv_products, rv_collection;
    ResponseModel responseModel;
    private HomeActivity2 homeActivity2;
    private Runnable apiRunnable = new Runnable() {
        @Override
        public void run() {
            getDataFromJson();
        }
    };

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_products = view.findViewById(R.id.rv_products);
        rv_collection = view.findViewById(R.id.rv_collection);
        createPOJO();
    }

    private void createPOJO() {
        Thread thread = new Thread(apiRunnable);
        thread.start();
    }

    private void getDataFromJson() {
        InputStream inputStream = null;
        try {
            inputStream = getActivity().getAssets().open("response.json");
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
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
                rv_products.setLayoutManager(gridLayoutManager);
                ProductsAdapter productsAdapter = new ProductsAdapter(responseModel.getExploreProducts(), HomeFragment.this::productItemClicked);
                rv_products.setAdapter(productsAdapter);
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        homeActivity2 = (HomeActivity2) context;
    }

    @Override
    public void productItemClicked(int position) {
        if (homeActivity2 != null) {
            homeActivity2.sendingAdapterPosition(position);
        }
    }


}