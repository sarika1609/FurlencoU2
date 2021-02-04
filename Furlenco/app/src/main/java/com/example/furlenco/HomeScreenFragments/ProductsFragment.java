package com.example.furlenco.HomeScreenFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.furlenco.Activities.HomeActivity2;
import com.example.furlenco.Interfaces.ProductsClickListener;
import com.example.furlenco.ProdcutsFragments.AppliancesFragment;
import com.example.furlenco.ProdcutsFragments.BedroomFragment;
import com.example.furlenco.ProdcutsFragments.DiningRoomFragment;
import com.example.furlenco.ProdcutsFragments.FullHomeFragment;
import com.example.furlenco.ProdcutsFragments.KidsRoomFragment;
import com.example.furlenco.ProdcutsFragments.LivingRoomFragment;
import com.example.furlenco.ProdcutsFragments.SpecialDealsFragment;
import com.example.furlenco.ProdcutsFragments.StorageFragment;
import com.example.furlenco.ProdcutsFragments.StudyRoomFragment;
import com.example.furlenco.ProdcutsFragments.TwoWheelersFragment;
import com.example.furlenco.R;
import com.google.android.material.tabs.TabLayout;

public class ProductsFragment extends Fragment implements ProductsClickListener {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private HomeActivity2 homeActivity2;

    public static ProductsFragment newInstance() {
        ProductsFragment fragment = new ProductsFragment();
        return fragment;
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
        viewPager = view.findViewById(R.id.viewPager3);
        tabLayout = view.findViewById(R.id.tabLayout3);
        setProductsViewPagerAdapter();
    }

    private void setProductsViewPagerAdapter() {
        ProductsViewPagerAdapter productsViewPagerAdapter = new ProductsViewPagerAdapter(getActivity().getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(productsViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        homeActivity2 = (HomeActivity2) context;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (homeActivity2 != null) {
            homeActivity2.sendListener(this);
        }

    }

    @Override
    public void onProductClicked(int position) {
        viewPager.setCurrentItem(position);
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
                    return BedroomFragment.newInstance();
                case 1:
                    return LivingRoomFragment.newInstance();
                case 2:
                    return AppliancesFragment.newInstance();
                case 3:
                    return FullHomeFragment.newInstance();
                case 4:
                    return StorageFragment.newInstance();
                case 5:
                    return StudyRoomFragment.newInstance();
                case 6:
                    return KidsRoomFragment.newInstance();
                case 7:
                    return DiningRoomFragment.newInstance();
                case 8:
                    return TwoWheelersFragment.newInstance();
                case 9:
                    return SpecialDealsFragment.newInstance();
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