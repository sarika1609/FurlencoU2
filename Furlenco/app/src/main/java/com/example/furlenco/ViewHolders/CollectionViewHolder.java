package com.example.furlenco.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.furlenco.ModelClasses.ProductModelClass;
import com.example.furlenco.R;

public class CollectionViewHolder extends RecyclerView.ViewHolder {
    ImageView iv_collection;
    TextView tv_collection;

    public CollectionViewHolder(@NonNull View itemView) {
        super(itemView);
        initUI(itemView);
    }

    private void initUI(View itemView) {
        iv_collection = itemView.findViewById(R.id.iv_collection);
        tv_collection = itemView.findViewById(R.id.tv_collection);
    }

    public void setCollectionData(ProductModelClass productModelClass) {
        tv_collection.setText(productModelClass.getName());
        Glide.with(iv_collection).load(productModelClass.getImage_url()).into(iv_collection);


    }
}
