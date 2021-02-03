package com.example.furlenco.ViewPagers;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.furlenco.ModelClasses.ProductModelClass;
import com.example.furlenco.POJOClasses.ExploreProductsItem;
import com.example.furlenco.R;

public class ProductsViewHolder extends RecyclerView.ViewHolder {
    LinearLayout ll_products;
    ImageView iv_product;
    TextView tv_product;


    public ProductsViewHolder(@NonNull View itemView) {
        super(itemView);
        initUI(itemView);
    }

    private void initUI(View itemView) {
        tv_product = itemView.findViewById(R.id.tv_product);
        iv_product = itemView.findViewById(R.id.iv_product);
        ll_products = itemView.findViewById(R.id.ll_products);

    }

    public void setData(ExploreProductsItem exploreProductsItem) {
        tv_product.setText(exploreProductsItem.getBedroom().get(0).getName());
        Glide.with(iv_product).
                load(exploreProductsItem.getBedroom().get(0).getImageUrl()).
                placeholder(R.drawable.ic_launcher_background).
                into(iv_product);
        ll_products.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
    }
}
