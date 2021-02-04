package com.example.furlenco.Activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.furlenco.Adapters.ProductsAdapter;
import com.example.furlenco.HomeScreenFragments.CartFragment;
import com.example.furlenco.HomeScreenFragments.CollectionsFragment;
import com.example.furlenco.HomeScreenFragments.HomeFragment;
import com.example.furlenco.HomeScreenFragments.MeFragment;
import com.example.furlenco.HomeScreenFragments.ProductsFragment;
import com.example.furlenco.POJOClasses.ResponseModel;
import com.example.furlenco.R;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;

public class HomeActivity2 extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.ic_outline_home_24,
            R.drawable.ic_cat1,
            R.drawable.ic_cat1,
            R.drawable.ic_outline_shopping_cart_24,
            R.drawable.ic_outline_person_24
    };
    private int[] tabIconsActive = {
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_cat2,
            R.drawable.ic_cat2,
            R.drawable.ic_baseline_shopping_cart_24,
            R.drawable.ic_baseline_person_24
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        initViews();
        setViewPagerAdapter();
    }

    private void setViewPagerAdapter() {
        HomeScreenViewPagerAdapter viewPagerAdapter = new HomeScreenViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        setUpIcons();
    }

    private void setUpIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_home_24);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tabLayout.getTabAt(tab.getPosition()).setIcon(tabIconsActive[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tabLayout.getTabAt(tab.getPosition()).setIcon(tabIcons[tab.getPosition()]);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager2);
        tabLayout = findViewById(R.id.tabLayout2);
    }



    private class HomeScreenViewPagerAdapter extends FragmentStatePagerAdapter {

        public HomeScreenViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return HomeFragment.newInstance();
                case 1:
                    return ProductsFragment.newInstance();
                case 2:
                    return CollectionsFragment.newInstance();
                case 3:
                    return CartFragment.newInstance();
                case 4:
                    return MeFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            String tabName = "";
            switch (position) {
                case 0:
                    return tabName = "Home";
                case 1:
                    return tabName = "Products";
                case 2:
                    return tabName = "Collections";
                case 3:
                    return tabName = "Cart";
                case 4:
                    return tabName = "Me";
            }
            return tabName;
        }
    }
}