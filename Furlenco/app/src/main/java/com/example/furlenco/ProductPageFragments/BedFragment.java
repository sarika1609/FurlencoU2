package com.example.furlenco.ProductPageFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.furlenco.Adapters.ProductsAdapter;
import com.example.furlenco.POJOClasses.ExploreProductsItem;
import com.example.furlenco.POJOClasses.ResponseModel;
import com.example.furlenco.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class BedFragment extends Fragment {
    RecyclerView rv_beds;
    List<ExploreProductsItem> exploreProductsItemList = new ArrayList<>();
    ResponseModel responseModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bed, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    private void initUI(View view) {
        rv_beds = view.findViewById(R.id.rv_beds);
        createPOJO();
    }
    private void createPOJO() {
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
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                rv_beds.setLayoutManager(gridLayoutManager);
               // ProductsAdapter productsAdapter = new ProductsAdapter(responseModel.getExploreProducts().get(0).getBedroom());
                //rv_beds.setAdapter(productsAdapter);
            }
        });
    }



    public static BedFragment newInstance() {
        BedFragment bedFragment = new BedFragment();
        return bedFragment;
    }

}