package com.example.furlenco.ProdcutsFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.furlenco.R;

public class DiningRoomFragment extends Fragment {

    public static DiningRoomFragment newInstance() {
        DiningRoomFragment fragment = new DiningRoomFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dining_room, container, false);
    }
}