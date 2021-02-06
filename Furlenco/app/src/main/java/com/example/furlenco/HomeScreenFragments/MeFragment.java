package com.example.furlenco.HomeScreenFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.furlenco.CartPreferenceHelper;
import com.example.furlenco.LoginActivities.LoginActivity;
import com.example.furlenco.R;

public class MeFragment extends Fragment {

    private Button mBtnLogin;
    private TextView mTvHi, mTvFurlencoGuest, mTvLocation;

    public static MeFragment newInstance() {
        MeFragment fragment = new MeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_me, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnLogin = view.findViewById(R.id.btnLogin);
        mTvHi = view.findViewById(R.id.tvHi);
        mTvLocation = view.findViewById(R.id.tvLocation);
        mTvFurlencoGuest = view.findViewById(R.id.tvFurlencoGuest);
        CartPreferenceHelper.getInstance(getContext());

        String location = CartPreferenceHelper.getString("city_name");
        mTvLocation.setText(location);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        String name = CartPreferenceHelper.getString("name");
        if (name != null) {
            mTvHi.setText(name);
        }

        String mobile = CartPreferenceHelper.getString("mobile");
        String email = CartPreferenceHelper.getString("email");
        if (mobile != null && email != null) {
            mTvFurlencoGuest.setText(mobile + "." + email);
        }


    }
}