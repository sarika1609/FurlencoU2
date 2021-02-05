package com.example.furlenco.HomeScreenAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.HomeScreenModelClasses.Curated;
import com.example.furlenco.HomeScreenModelClasses.Design;
import com.example.furlenco.HomeScreenModelClasses.Renting;
import com.example.furlenco.HomeScreenViewHolders.RentingDescriptionViewHolder;
import com.example.furlenco.HomeScreenViewHolders.RentingImageViewHolder;
import com.example.furlenco.R;

import java.util.List;

public class CuratedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Curated> curatedList;

    public CuratedAdapter(List<Curated> curatedList) {
        this.curatedList = curatedList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Curated.ITEM_TYPE_IMAGE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.renting_image_item_layout, parent, false);
                return new RentingImageViewHolder(view);
            case Curated.ITEM_TYPE_DESC:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.renting_desc_item_layout, parent, false);
                return new RentingDescriptionViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.renting_image_item_layout, parent, false);
                return new RentingImageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Curated curated = curatedList.get(position);
        int viewType = curated.getViewType();

        switch (viewType) {
            case Curated.ITEM_TYPE_IMAGE:
                if (holder instanceof RentingImageViewHolder) {
                    ((RentingImageViewHolder) holder).setDataForCurated(curated);
                    break;
                }
            case Curated.ITEM_TYPE_DESC:
                if (holder instanceof RentingDescriptionViewHolder) {
                    ((RentingDescriptionViewHolder) holder).setDataForCurated(curated);
                    break;
                }
        }
    }

    @Override
    public int getItemViewType(int position) {
        return curatedList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return curatedList.size();
    }
}
