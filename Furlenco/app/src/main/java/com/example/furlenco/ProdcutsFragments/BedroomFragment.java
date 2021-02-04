package com.example.furlenco.ProdcutsFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.furlenco.Interfaces.RecyclerItemClickListener;
import com.example.furlenco.POJOClasses.BedroomItem;
import com.example.furlenco.R;

import java.util.ArrayList;
import java.util.List;

public class BedroomFragment extends Fragment implements RecyclerItemClickListener {

    private RecyclerView rvBedroom;
    private List<BedroomItem> bedroomItemList;

    public static BedroomFragment newInstance() {
        BedroomFragment bedroomFragment = new BedroomFragment();
        return bedroomFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bedroom, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);

    }

    private void initViews(View view) {
        rvBedroom = view.findViewById(R.id.rvBedroom);
        bindRecyclerData();
    }

    private void bindRecyclerData() {
        bedroomItemList = new ArrayList<>();
    }

    @Override
    public void onItemClicked(BedroomItem bedroomItem) {

    }
}