package com.example.furlenco.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.Interfaces.RecyclerItemClickListener;
import com.example.furlenco.POJOClasses.BedroomItem;
import com.example.furlenco.R;
import com.example.furlenco.ViewHolders.ProductViewHolder;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private RecyclerItemClickListener listener;
    private List<BedroomItem> bedroomItemList;

    public ProductAdapter(RecyclerItemClickListener listener, List<BedroomItem> bedroomItemList) {
        this.listener = listener;
        this.bedroomItemList = bedroomItemList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_layout,parent,false);
        return new ProductViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        BedroomItem bedroomItem = bedroomItemList.get(position);
        holder.setData(bedroomItem);
    }

    @Override
    public int getItemCount() {
        return bedroomItemList.size();
    }
}
