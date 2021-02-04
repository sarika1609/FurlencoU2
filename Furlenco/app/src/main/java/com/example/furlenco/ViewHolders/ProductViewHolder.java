package com.example.furlenco.ViewHolders;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.Interfaces.RecyclerItemClickListener;
import com.example.furlenco.POJOClasses.BedroomItem;
import com.example.furlenco.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    private TextView tvOffer, tvVariant, tvPrice, tvName;
    private LinearLayout llProduct;
    private RecyclerItemClickListener listener;

    public ProductViewHolder(@NonNull View itemView,RecyclerItemClickListener listener) {
        super(itemView);
        this.listener = listener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvName = itemView.findViewById(R.id.tvName);
        tvOffer = itemView.findViewById(R.id.tvOffer);
        tvVariant = itemView.findViewById(R.id.tvVariant);
        tvPrice = itemView.findViewById(R.id.tvPrice);
        llProduct = itemView.findViewById(R.id.llProduct);
    }

    public void setData(BedroomItem bedroomItem){
        tvName.setText(bedroomItem.getName());
        tvOffer.setText(bedroomItem.getOffer());
        tvPrice.setText(bedroomItem.getMonthlyRental());
        tvVariant.setText(bedroomItem.getVariants());

        llProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClicked(bedroomItem);
            }
        });
    }
}
