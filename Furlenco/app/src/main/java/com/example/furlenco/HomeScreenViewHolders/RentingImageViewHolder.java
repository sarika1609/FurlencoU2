package com.example.furlenco.HomeScreenViewHolders;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.HomeScreenModelClasses.Curated;
import com.example.furlenco.HomeScreenModelClasses.Design;
import com.example.furlenco.HomeScreenModelClasses.Renting;
import com.example.furlenco.R;

public class RentingImageViewHolder extends RecyclerView.ViewHolder {

    private ImageView mIvImage;

    public RentingImageViewHolder(@NonNull View itemView) {
        super(itemView);
        mIvImage = itemView.findViewById(R.id.ivRentingImage);
    }

    public void setData(Renting renting) {
        mIvImage.setImageResource(renting.getImage());
    }

    public void setDataForDesign(Design design) {
        mIvImage.setImageResource(design.getImage());

    }

    public void setDataForCurated(Curated curated) {
        mIvImage.setImageResource(curated.getImage());
    }
}
