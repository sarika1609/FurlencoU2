package com.example.furlenco.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.furlenco.Activities.HomeActivity;
import com.example.furlenco.Activities.MainActivity;
import com.example.furlenco.Activities.ProductsActivity;
import com.example.furlenco.R;
import com.google.android.material.tabs.TabLayout;


public class BedRoomFragment extends Fragment {
    ViewPager bed_viewpager;
    TabLayout bed_tablayout;
    HomeActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bed_room, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    private void initUI(View view) {
        bed_tablayout = view.findViewById(R.id.bed_tablayout);
        bed_viewpager = view.findViewById(R.id.bed_viewpager);
        setBedRoomViewPageAdapter();
    }

    private void setBedRoomViewPageAdapter() {
        BedViewPagerAdapter productsViewPagerAdapter = new BedViewPagerAdapter(getChildFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        bed_viewpager.setAdapter(productsViewPagerAdapter);
        bed_tablayout.setupWithViewPager(bed_viewpager);
    }

    private class BedViewPagerAdapter extends FragmentStatePagerAdapter {

        public BedViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return BedFragment.newInstance();
                case 1:
                    return BedFragment.newInstance();
                case 2:
                    return BedFragment.newInstance();
                case 3:
                    return BedFragment.newInstance();
                case 4:
                    return BedFragment.newInstance();
                case 5:
                    return BedFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String name = "Tab1";
            switch (position) {
                case 0:
                    name = "Queen Bed";
                    break;
                case 1:
                    name = "Storage Bed";
                    break;
                case 2:
                    name = "Single Bed";
                    break;
                case 3:
                    name = "Multifunctional";
                    break;
                case 4:
                    name = "Bedroom Storage";
                    break;
                case 5:
                    name = "Deals";
                    break;
            }
            return name;
        }
    }


    public static BedRoomFragment newInstance() {
        BedRoomFragment bedRoomFragment = new BedRoomFragment();
        return bedRoomFragment;
    }
}