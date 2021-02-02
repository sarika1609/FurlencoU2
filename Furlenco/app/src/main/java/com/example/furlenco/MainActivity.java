package com.example.furlenco;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.furlenco.InitialScreenFragments.FragmentFive;
import com.example.furlenco.InitialScreenFragments.FragmentFour;
import com.example.furlenco.InitialScreenFragments.FragmentOne;
import com.example.furlenco.InitialScreenFragments.FragmentThree;
import com.example.furlenco.InitialScreenFragments.FragmentTwo;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FragmentManager fragmentManager;
    private String tag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setViewPagerAdapter();
    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        fragmentManager = getSupportFragmentManager();
    }

    private void setViewPagerAdapter() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter{

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return FragmentOne.newInstance();
                case 1:
                    return FragmentTwo.newInstance();
                case 2:
                    return FragmentThree.newInstance();
                case 3:
                    return FragmentFour.newInstance();
                case 4:
                    return FragmentFive.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }
    }

//    public void launchFragment(String tag) {
//        this.tag = tag;
//        if (tag.equals("Skip")) {
//            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//            FragmentFive fragmentFive = new FragmentFive();
//            fragmentTransaction.replace(R.id.flContainer, fragmentFive, "FragmentFive").addToBackStack("FragmentFive").commit();
//        }
//    }
//
//    public void openFifthFragment(CommunicationListener listener) {
//        if (listener != null) {
//            listener.onDataPassed(tag);
//        }
//    }
}