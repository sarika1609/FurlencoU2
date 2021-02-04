package com.example.furlenco.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.furlenco.Activities.HomeActivity;
import com.example.furlenco.Adapters.ProductsAdapter;
import com.example.furlenco.POJOClasses.ExploreProductsItem;
import com.example.furlenco.R;

import java.util.ArrayList;
import java.util.List;


public class BedFragment extends Fragment {
    RecyclerView rv_beds;
    List<ExploreProductsItem> exploreProductsItemList = new ArrayList<>();

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
        setBedsData();
    }

    private void setBedsData() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rv_beds.setLayoutManager(gridLayoutManager);
        ProductsAdapter productsAdapter = new ProductsAdapter(exploreProductsItemList);
        rv_beds.setAdapter(productsAdapter);
    }

    public static BedFragment newInstance() {
        BedFragment bedFragment = new BedFragment();
        return bedFragment;
    }

}