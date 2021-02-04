package com.example.furlenco.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.ModelClasses.CartModelClass;
import com.example.furlenco.R;
import com.example.furlenco.ViewHolders.ViewCartHolder;

import java.util.ArrayList;
import java.util.List;

public class ViewCartAdapter extends RecyclerView.Adapter<ViewCartHolder> {
    List<CartModelClass> cartModelClassList=new ArrayList<>();

    public ViewCartAdapter(List<CartModelClass> cartModelClassList) {
        this.cartModelClassList = cartModelClassList;
    }

    @NonNull
    @Override
    public ViewCartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_cart_items_layout, parent, false);
        return new ViewCartHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewCartHolder holder, int position) {
        CartModelClass cartModelClass = cartModelClassList.get(position);
        holder.setData(cartModelClass);
    }

    @Override
    public int getItemCount() {
        return cartModelClassList.size();
    }
}
