package com.example.furlenco.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.furlenco.Activities.MainActivity;
import com.example.furlenco.R;

public class FragmentOne extends Fragment {

    private Button mBtnSkip;
    private Button mBtnNext;
    private MainActivity mainActivity;

    public static FragmentOne newInstance() {
        FragmentOne fragmentOne = new FragmentOne();
        return fragmentOne;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnSkip = view.findViewById(R.id.btnSkip);
        mBtnNext = view.findViewById(R.id.btnNext);



//        mBtnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                (MainActivity(getActivity())
//            }
//        });
    }

    @Override
    public void onResume() {
        super.onResume();
//        mBtnSkip.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("tag","tag");
//                FragmentFive.newInstance();
////                mainActivity.launchFragment("Skip");
//            }
//        });
    }
}