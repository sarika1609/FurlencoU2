package com.example.furlenco.HomeScreenAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.HomeScreenModelClasses.Design;
import com.example.furlenco.HomeScreenModelClasses.Renting;
import com.example.furlenco.HomeScreenViewHolders.RentingDescriptionViewHolder;
import com.example.furlenco.HomeScreenViewHolders.RentingImageViewHolder;
import com.example.furlenco.R;

import java.util.List;

public class DesignAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Design> designList;

    public DesignAdapter(List<Design> designList) {
        this.designList = designList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Renting.ITEM_TYPE_IMAGE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.renting_image_item_layout, parent, false);
                return new RentingImageViewHolder(view);
            case Renting.ITEM_TYPE_DESC:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.renting_desc_item_layout, parent, false);
                return new RentingDescriptionViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.renting_image_item_layout, parent, false);
                return new RentingImageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Design design = designList.get(position);
        int viewType = design.getViewType();

        switch (viewType) {
            case Renting.ITEM_TYPE_IMAGE:
                if (holder instanceof RentingImageViewHolder) {
                    ((RentingImageViewHolder) holder).setDataForDesign(design);
                    break;
                }
            case Renting.ITEM_TYPE_DESC:
                if (holder instanceof RentingDescriptionViewHolder) {
                    ((RentingDescriptionViewHolder) holder).setDataForDesign(design);
                    break;
                }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return designList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return designList.size();
    }
}
