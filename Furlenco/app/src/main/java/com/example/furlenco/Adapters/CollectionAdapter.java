package com.example.furlenco.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.ViewPagers.CollectionViewHolder;
import com.example.furlenco.ModelClasses.ProductModelClass;
import com.example.furlenco.R;

import java.util.List;

public class CollectionAdapter extends RecyclerView.Adapter<CollectionViewHolder> {
    List<ProductModelClass> productModelClassList;

    public CollectionAdapter(List<ProductModelClass> productModelClassList) {
        this.productModelClassList=productModelClassList;
    }

    @NonNull
    @Override
    public CollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.collection_item_layout, parent, false);
        return new CollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CollectionViewHolder holder, int position) {
        ProductModelClass productModelClass = productModelClassList.get(position);
        holder.setCollectionData(productModelClass);
    }

    @Override
    public int getItemCount() {
        return productModelClassList.size();
    }
}
