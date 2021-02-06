package com.example.furlenco.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.furlenco.R;
import com.example.furlenco.StartScreenFragments.FragmentFive;
import com.example.furlenco.StartScreenFragments.FragmentFour;
import com.example.furlenco.StartScreenFragments.FragmentOne;
import com.example.furlenco.StartScreenFragments.FragmentThree;
import com.example.furlenco.StartScreenFragments.FragmentTwo;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Button mBtnSkip;
    private Button mBtnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setViewPagerAdapter();
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void initViews() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        mBtnSkip = findViewById(R.id.btnSkip);
        mBtnNext = findViewById(R.id.btnNext);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 4) {
                    mBtnNext.setVisibility(View.GONE);
                    mBtnSkip.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(getItem(+1), true);
            }
        });

        mBtnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(4);
            }
        });
    }

    private void setViewPagerAdapter() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    mBtnNext.setVisibility(View.VISIBLE);
                    mBtnSkip.setVisibility(View.VISIBLE);
                    return FragmentOne.newInstance();
                case 1:
                    mBtnNext.setVisibility(View.VISIBLE);
                    mBtnSkip.setVisibility(View.VISIBLE);
                    return FragmentTwo.newInstance();
                case 2:
                    mBtnNext.setVisibility(View.VISIBLE);
                    mBtnSkip.setVisibility(View.VISIBLE);
                    return FragmentThree.newInstance();
                case 3:
                    mBtnNext.setVisibility(View.VISIBLE);
                    mBtnSkip.setVisibility(View.VISIBLE);
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
}