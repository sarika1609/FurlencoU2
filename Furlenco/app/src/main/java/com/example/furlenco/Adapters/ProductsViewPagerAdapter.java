package com.example.furlenco.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.furlenco.ProductPageFragments.BedRoomFragment;

public class ProductsViewPagerAdapter extends FragmentStatePagerAdapter {
    public ProductsViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return BedRoomFragment.newInstance();
            case 1:
                return BedRoomFragment.newInstance();
            case 2:
                return BedRoomFragment.newInstance();
            case 3:
                return BedRoomFragment.newInstance();
            case 4:
                return BedRoomFragment.newInstance();
            case 5:
                return BedRoomFragment.newInstance();
            case 6:
                return BedRoomFragment.newInstance();
            case 7:
                return BedRoomFragment.newInstance();
            case 8:
                return BedRoomFragment.newInstance();
            case 9:
                return BedRoomFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String name = "Tab1";
        switch (position) {
            case 0:
                name = "Bed Room";
                break;
            case 1:
                name = "Living Room";
                break;
            case 2:
                name = "Appliances";
                break;
            case 3:
                name = "Full Home";
                break;
            case 4:
                name = "Storage";
                break;
            case 5:
                name = "Study Room";
                break;
            case 6:
                name = "Kids Room";
                break;
            case 7:
                name = "Dining Room";
                break;
            case 8:
                name = "2-Wheelers";
                break;
            case 9:
                name = "Special Deals";
                break;
        }
        return name;
    }
}