package com.example.furlenco.HomeScreenFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.furlenco.Adapters.ProductsViewPagerAdapter;
import com.example.furlenco.POJOClasses.ResponseModel;
import com.example.furlenco.R;
import com.google.android.material.tabs.TabLayout;

public class ProductsFragment extends Fragment {
    ViewPager m_viewpager;
    TabLayout m_tablayout;
    ResponseModel responseModel;

    public static ProductsFragment newInstance() {
        ProductsFragment fragment = new ProductsFragment();
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
        return inflater.inflate(R.layout.fragment_products, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    private void initUI(View view) {
        m_tablayout = view.findViewById(R.id.m_tablayout);
        m_viewpager = view.findViewById(R.id.m_viewpager);
        setProductsViewPagerAdapter();
    }


    private void setProductsViewPagerAdapter() {
        ProductsViewPagerAdapter productsViewPagerAdapter = new ProductsViewPagerAdapter(getChildFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        m_viewpager.setAdapter(productsViewPagerAdapter);
        m_tablayout.setupWithViewPager(m_viewpager);
    }


}