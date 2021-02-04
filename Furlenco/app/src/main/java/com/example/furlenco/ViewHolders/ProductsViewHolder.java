package com.example.furlenco.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.furlenco.Interfaces.OnProductClick;
import com.example.furlenco.POJOClasses.ExploreProductsItem;
import com.example.furlenco.R;

public class ProductsViewHolder extends RecyclerView.ViewHolder {
    LinearLayout ll_products;
    ImageView iv_product;
    TextView tv_product;
    OnProductClick onProductClick;

    public ProductsViewHolder(@NonNull View itemView, OnProductClick onProductClick) {
        super(itemView);
        initUI(itemView);
        this.onProductClick = onProductClick;
    }

    private void initUI(View itemView) {
        tv_product = itemView.findViewById(R.id.tv_product);
        iv_product = itemView.findViewById(R.id.iv_product);
        ll_products = itemView.findViewById(R.id.ll_products);

    }

    public void setData(ExploreProductsItem exploreProductsItem) {
        if (exploreProductsItem.getName()==null) {
            tv_product.setText("dummy");
        } else tv_product.setText(exploreProductsItem.getName());

        if (exploreProductsItem.getImageUrl()==null){
            iv_product.setImageResource(R.drawable.ic_discount);
        }else {
            Glide.with(iv_product).
                    load(exploreProductsItem.getImageUrl()).
                    placeholder(R.drawable.ic_launcher_background).
                    into(iv_product);
        }

        ll_products.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                onProductClick.productItemClicked(getAdapterPosition());
            }
        });
    }
}
