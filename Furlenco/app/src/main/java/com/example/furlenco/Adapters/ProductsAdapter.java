package com.example.furlenco.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.Interfaces.OnProductClick;
import com.example.furlenco.ModelClasses.ProductModelClass;
import com.example.furlenco.POJOClasses.ExploreProductsItem;
import com.example.furlenco.ViewHolders.ProductsViewHolder;
import com.example.furlenco.R;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {
    List<ExploreProductsItem> exploreProductsItemList;
    List<ProductModelClass> productModelClassList;
    OnProductClick onProductClick;

    public ProductsAdapter(List<ProductModelClass> productModelClassList, OnProductClick onProductClick) {
        this.productModelClassList = productModelClassList;
        this.onProductClick = onProductClick;
    }

    public ProductsAdapter(List<ExploreProductsItem> exploreProductsItemList) {
        this.exploreProductsItemList = exploreProductsItemList;
    }

    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_item_layout, parent, false);
        return new ProductsViewHolder(view, onProductClick);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {
        ExploreProductsItem exploreProductsItem = exploreProductsItemList.get(position);
        holder.setData(exploreProductsItem);
    }

    @Override
    public int getItemCount() {
        return exploreProductsItemList.size();
    }
}
