package com.example.furlenco.HomeScreenFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.Adapters.ViewCartAdapter;
import com.example.furlenco.CartPreferenceHelper;
import com.example.furlenco.Listeners.CartCommunationListner;
import com.example.furlenco.LoginActivities.LoginActivity;
import com.example.furlenco.ModelClasses.CartModelClass;
import com.example.furlenco.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment {
    RecyclerView rv_carts;
    List<CartModelClass> cartModelClassList;
    CartCommunationListner listner;
    private Button mBtnContinue;

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
        mBtnContinue = view.findViewById(R.id.btnContinue);
        CartPreferenceHelper.getInstance(getContext());
        mBtnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CartPreferenceHelper.getString("name").equalsIgnoreCase("")) {
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                } else Toast.makeText(getContext(),"Order Placed",Toast.LENGTH_SHORT).show();

            }
        });
        getList();
        setCardAdapterData(cartModelClassList);

    }

    private void setCardAdapterData(List<CartModelClass> cartModelClassList) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        rv_carts.setLayoutManager(linearLayoutManager);
        ViewCartAdapter viewCartAdapter = new ViewCartAdapter(cartModelClassList);
        rv_carts.setAdapter(viewCartAdapter);

    }


    public List<CartModelClass> getList() {
        cartModelClassList = new ArrayList<>();
        CartPreferenceHelper.getInstance(getActivity());
        if (cartModelClassList != null) {
            String serializedObject = CartPreferenceHelper.getString("data");
            if (serializedObject != null) {
                Gson gson = new Gson();
                Type type = new TypeToken<List<CartModelClass>>() {
                }.getType();
                cartModelClassList = gson.fromJson(serializedObject, type);
            }
        }
        return cartModelClassList;
    }

}