package com.example.furlenco.ProdcutsFragments;

import android.content.Context;
import android.content.Intent;
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

import com.example.furlenco.ProductScreen.AddCartActivity;
import com.example.furlenco.Activities.HomeActivity;
import com.example.furlenco.Adapters.ProductAdapter;
import com.example.furlenco.Interfaces.RecyclerItemClickListener;
import com.example.furlenco.POJOClasses.AppliancesItem;
import com.example.furlenco.POJOClasses.BedroomItem;
import com.example.furlenco.POJOClasses.DiningRoomItem;
import com.example.furlenco.POJOClasses.FullHomeItem;
import com.example.furlenco.POJOClasses.JsonMember2WheelersItem;
import com.example.furlenco.POJOClasses.KidsRoomItem;
import com.example.furlenco.POJOClasses.LivingRoomItem;
import com.example.furlenco.POJOClasses.ResponseModel;
import com.example.furlenco.POJOClasses.SpecialDealsItem;
import com.example.furlenco.POJOClasses.StorageItem;
import com.example.furlenco.POJOClasses.StudyRoomItem;
import com.example.furlenco.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;

public class FullHomeFragment extends Fragment implements RecyclerItemClickListener {
    private RecyclerView rvfullhome;
    ResponseModel responseModel;
    HomeActivity homeActivity;

    public static FullHomeFragment newInstance() {
        FullHomeFragment fragment = new FullHomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private Runnable apiRunnable = new Runnable() {
        @Override
        public void run() {
            getDataFromJson();
        }
    };

    private void initViews(View view) {
        rvfullhome = view.findViewById(R.id.rvfullhome);
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
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
                rvfullhome.setLayoutManager(gridLayoutManager);
                ProductAdapter productAdapter = new ProductAdapter(FullHomeFragment.this, responseModel.getExploreProducts().get(3).getFullHome(), "Full Room");
                rvfullhome.setAdapter(productAdapter);
            }
        });
    }

    @Override
    public void onLivingItemClicked(LivingRoomItem livingRoomItem) {

    }

    @Override
    public void onItemClicked(BedroomItem bedroomItem) {

    }

    @Override
    public void onApplianceItemClicked(AppliancesItem appliancesItem) {

    }

    @Override
    public void onFullHomeItemClicked(FullHomeItem fullHomeItem) {

        Intent intent= new Intent(getContext(), AddCartActivity.class);
        intent.putExtra("name",fullHomeItem.getName());
        intent.putExtra("url",fullHomeItem.getImageUrl());
        intent.putExtra("rent",fullHomeItem.getMonthlyRental());
        intent.putExtra("price",fullHomeItem.getPrice());
        intent.putExtra("url2", fullHomeItem.getImageUrl2());
        intent.putExtra("win1", fullHomeItem.getWin1().getName());
        intent.putExtra("win2", fullHomeItem.getWin2().getName());
        startActivity(intent);
    }

    private void sendDataToActivity(String name,String url) {
        if (homeActivity !=null){
            homeActivity.setBedRoomCartData(name,url,"full_tag");
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        homeActivity= (HomeActivity) context;
    }

    @Override
    public void onStorageItemClicked(StorageItem storageItem) {

    }

    @Override
    public void onStudyRoomItemClicked(StudyRoomItem studyRoomItem) {

    }

    @Override
    public void onKidsItemClicked(KidsRoomItem kidsRoomItem) {

    }


    @Override
    public void onDiningItemClicked(DiningRoomItem diningRoomItem) {

    }

    @Override
    public void onTwoWheelerItemClicked(JsonMember2WheelersItem jsonMember2WheelersItem) {

    }

    @Override
    public void onSpecialOfferItemClicked(SpecialDealsItem specialDealsItem) {

    }

}
