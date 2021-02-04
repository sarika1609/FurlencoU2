package com.example.furlenco.HomeScreenFragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.furlenco.Activities.HomeActivity;
import com.example.furlenco.Adapters.ViewCartAdapter;
import com.example.furlenco.Listners.CartCommunationListner;
import com.example.furlenco.ModelClasses.CartModelClass;
import com.example.furlenco.R;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment implements CartCommunationListner {
    RecyclerView rv_carts;
    CartModelClass cartModelClass;
    HomeActivity homeActivity;
    List<CartModelClass> cartModelClassList = new ArrayList<>();
    CartCommunationListner listner;

    public static CartFragment newInstance() {
        CartFragment fragment = new CartFragment();
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
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    private void initUI(View view) {
        rv_carts = view.findViewById(R.id.rv_carts);
        setCardAdapterData(cartModelClassList);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        homeActivity = (HomeActivity) context;
    }

    @Override
    public void onResume() {
        super.onResume();
        setCardAdapterData(cartModelClassList);
        if (homeActivity != null) {
            homeActivity.sendCartDataToDisplayFragment(this);
        }

    }

    private void setCardAdapterData(List<CartModelClass> cartModelClassList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv_carts.setLayoutManager(linearLayoutManager);
        ViewCartAdapter viewCartAdapter = new ViewCartAdapter(cartModelClassList);
        rv_carts.setAdapter(viewCartAdapter);

    }


    @Override
    public void updateCartList(List<CartModelClass> cartModelClassList) {
        setCardAdapterData(cartModelClassList);
    }
}