package com.example.furlenco.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.furlenco.ModelClasses.CartModelClass;
import com.example.furlenco.R;

public class ViewCartHolder extends RecyclerView.ViewHolder {
    ImageView iv_item;
    TextView tv_item_delivery, tv_item_name, tv_item_count, tv_item_price, tv_item_discount, tv_item_gst;

    public ViewCartHolder(@NonNull View itemView) {
        super(itemView);
        initUI(itemView);
    }

    private void initUI(View itemView) {
        tv_item_delivery = itemView.findViewById(R.id.tv_item_delivery);
        tv_item_name = itemView.findViewById(R.id.tv_item_name);
        tv_item_count = itemView.findViewById(R.id.tv_item_count);
        tv_item_price = itemView.findViewById(R.id.tv_item_price);
        tv_item_gst = itemView.findViewById(R.id.tv_item_gst);
        iv_item = itemView.findViewById(R.id.iv_item);
    }

    public void setData(CartModelClass cartModelClass) {
        tv_item_name.setText(cartModelClass.getName());
        tv_item_delivery.setText(cartModelClass.getDelivery_time());
        tv_item_count.setText("1 +");
        tv_item_price.setText(cartModelClass.getPrice());
        tv_item_gst.setText(cartModelClass.getGst() + "");
        Glide.with(iv_item).load(cartModelClass.getUrl()).placeholder(R.drawable.loading).into(iv_item);


    }
}
