package com.example.furlenco.InitialScreenFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.example.furlenco.R;

public class FragmentThree extends Fragment {

    private Button mBtnSkip;
    private Button mBtnNext;

    public static FragmentThree newInstance() {
        FragmentThree fragmentThree = new FragmentThree();
        return fragmentThree;
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
        return inflater.inflate(R.layout.fragment_three, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        LottieAnimationView lottieAnimationView = view.findViewById(R.id.animationView3);
//        lottieAnimationView.setImageAssetsFolder("images/");
//        lottieAnimationView.setAnimation(R.raw.travel);
//        lottieAnimationView.playAnimation();
    }
}