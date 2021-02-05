package com.example.furlenco.HomeScreenAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.HomeScreenModelClasses.Renting;
import com.example.furlenco.HomeScreenViewHolders.RentingDescriptionViewHolder;
import com.example.furlenco.HomeScreenViewHolders.RentingImageViewHolder;
import com.example.furlenco.R;

import java.util.List;

public class RentingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Renting> rentingList;

    public RentingAdapter(List<Renting> rentingList) {
        this.rentingList = rentingList;
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
        Renting renting = rentingList.get(position);
        int viewType = renting.getViewType();

        switch (viewType) {
            case Renting.ITEM_TYPE_IMAGE:
                if (holder instanceof RentingImageViewHolder) {
                    ((RentingImageViewHolder) holder).setData(renting);
                    break;
                }
            case Renting.ITEM_TYPE_DESC:
                if (holder instanceof RentingDescriptionViewHolder) {
                    ((RentingDescriptionViewHolder) holder).setData(renting);
                    break;
                }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return rentingList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return rentingList.size();
    }
}
