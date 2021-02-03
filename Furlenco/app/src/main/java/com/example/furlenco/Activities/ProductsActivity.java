package com.example.furlenco.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

import com.example.furlenco.Fragments.BedRoomFragment;
import com.example.furlenco.Fragments.FragmentFive;
import com.example.furlenco.Fragments.FragmentFour;
import com.example.furlenco.Fragments.FragmentOne;
import com.example.furlenco.Fragments.FragmentThree;
import com.example.furlenco.Fragments.FragmentTwo;
import com.example.furlenco.R;
import com.google.android.material.tabs.TabLayout;

public class ProductsActivity extends AppCompatActivity {
    ViewPager m_viewpager;
    TabLayout m_tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        initUI();
    }

    private void initUI() {
        m_tablayout = findViewById(R.id.m_tablayout);
        m_viewpager = findViewById(R.id.m_viewpager);
        setProductsViewPagerAdapter();
    }

    private void setProductsViewPagerAdapter() {
        ProductsViewPagerAdapter productsViewPagerAdapter = new ProductsViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        m_viewpager.setAdapter(productsViewPagerAdapter);
        m_tablayout.setupWithViewPager(m_viewpager);
    }

    private class ProductsViewPagerAdapter extends FragmentStatePagerAdapter {
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
}
