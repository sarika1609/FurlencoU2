package com.example.furlenco;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

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

    public void setData(ProductModelClass productModelClass) {
        tv_product.setText(productModelClass.getName());
        Glide.with(iv_product).
                load(productModelClass.getImage_url()).
                placeholder(R.drawable.ic_launcher_background).
                into(iv_product);
        ll_products.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
    }
}