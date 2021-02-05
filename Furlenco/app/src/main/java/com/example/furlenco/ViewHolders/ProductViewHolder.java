package com.example.furlenco.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.furlenco.Interfaces.RecyclerItemClickListener;
import com.example.furlenco.POJOClasses.AppliancesItem;
import com.example.furlenco.POJOClasses.BedroomItem;
import com.example.furlenco.POJOClasses.DiningRoomItem;
import com.example.furlenco.POJOClasses.ExploreProductsItem;
import com.example.furlenco.POJOClasses.FullHomeItem;
import com.example.furlenco.POJOClasses.JsonMember2WheelersItem;
import com.example.furlenco.POJOClasses.KidsRoomItem;
import com.example.furlenco.POJOClasses.LivingRoomItem;
import com.example.furlenco.POJOClasses.SpecialDealsItem;
import com.example.furlenco.POJOClasses.StorageItem;
import com.example.furlenco.POJOClasses.StudyRoomItem;
import com.example.furlenco.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    private TextView tvOffer, tvVariant, tvPrice, tvName;
    private LinearLayout llProduct;
    private RecyclerItemClickListener listener;
    private ImageView ivImage;

    public ProductViewHolder(@NonNull View itemView, RecyclerItemClickListener listener) {
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
        ivImage = itemView.findViewById(R.id.ivImage);
    }


    public void setLivingRoomData(LivingRoomItem livingRoomItem, String name) {
        if (name != null) {
            if (name.equalsIgnoreCase("Living Room")) {
                tvName.setText(livingRoomItem.getName());
                tvOffer.setText(livingRoomItem.getOffer());
                tvPrice.setText(livingRoomItem.getMonthlyRental());
                tvVariant.setText(livingRoomItem.getVariants());
                Glide.with(ivImage).load(livingRoomItem.getImageUrl()).into(ivImage);

                llProduct.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onLivingItemClicked(livingRoomItem);
                    }
                });
            }
        }
    }

    public void setBedRoomData(BedroomItem bedRoomData, String name) {
        if (name != null &&name.equalsIgnoreCase("Bed Room")) {
            tvName.setText(bedRoomData.getName());
            tvOffer.setText(bedRoomData.getOffer());
            tvPrice.setText(bedRoomData.getMonthlyRental());
            tvVariant.setText(bedRoomData.getVariants());
            Glide.with(ivImage).load(bedRoomData.getImageUrl()).into(ivImage);

            llProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClicked(bedRoomData);
                }
            });
        }
    }

    public void setApplianceRoomData(AppliancesItem appliancesItem, String name) {
        if (name != null &&name.equalsIgnoreCase("Appliance Room")) {
            tvName.setText(appliancesItem.getName());
            tvOffer.setText(appliancesItem.getOffer());
            tvPrice.setText(appliancesItem.getMonthlyRental());
            //tvVariant.setText(appliancesItem.getVariants());
            Glide.with(ivImage).load(appliancesItem.getImageUrl()).into(ivImage);

            llProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onApplianceItemClicked(appliancesItem);
                }
            });
        }
    }

    public void setFullRoomData(FullHomeItem fullHomeItem, String name) {
        if (name != null &&name.equalsIgnoreCase("Full Room")) {
            tvName.setText(fullHomeItem.getName());
            tvOffer.setText(fullHomeItem.getOffer());
            tvPrice.setText(fullHomeItem.getMonthlyRental());
            // tvVariant.setText(fullHomeItem.getVariants());
            Glide.with(ivImage).load(fullHomeItem.getImageUrl()).into(ivImage);

            llProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onFullHomeItemClicked(fullHomeItem);
                }
            });
        }
    }

    public void setStorageData(StorageItem storageItem, String name) {
        if (name != null &&name.equalsIgnoreCase("Storage Room")) {
            tvName.setText(storageItem.getName());
            tvOffer.setText(storageItem.getOffer());
            tvPrice.setText(storageItem.getMonthlyRental());
            //tvVariant.setText(storageItem.getVariants());
            Glide.with(ivImage).load(storageItem.getImageUrl()).into(ivImage);

            llProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onStorageItemClicked(storageItem);
                }
            });
        }
    }

    public void setStudhoyRoomData(StudyRoomItem studyRoomItem, String name) {
        if (name != null &&name.equalsIgnoreCase("Study Room")) {
            tvName.setText(studyRoomItem.getName());
            tvOffer.setText(studyRoomItem.getOffer());
            tvPrice.setText(studyRoomItem.getMonthlyRental());
            //  tvVariant.setText(studyRoomItem.getVariants());
            Glide.with(ivImage).load(studyRoomItem.getImageUrl()).into(ivImage);

            llProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onStudyRoomItemClicked(studyRoomItem);
                }
            });
        }
    }

    public void setKidsRoomData(KidsRoomItem kidsRoomItem, String name) {
        if (name != null &&name.equalsIgnoreCase("Kids Room")) {
            tvName.setText(kidsRoomItem.getName());
            tvOffer.setText(kidsRoomItem.getOffer());
            tvPrice.setText(kidsRoomItem.getMonthlyRental());
            // tvVariant.setText(kidsRoomItem.getVariants());
            Glide.with(ivImage).load(kidsRoomItem.getImageUrl()).into(ivImage);

            llProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onKidsItemClicked(kidsRoomItem);
                }
            });
        }
    }

    public void setDiningRoomData(DiningRoomItem diningRoomItem, String name) {
        if (name.equalsIgnoreCase("Dining Room")) {
            tvName.setText(diningRoomItem.getName());
            tvOffer.setText(diningRoomItem.getOffer());
            tvPrice.setText(diningRoomItem.getMonthlyRental());
            tvVariant.setText(diningRoomItem.getVariants());
            Glide.with(ivImage).load(diningRoomItem.getImageUrl()).into(ivImage);

            llProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onDiningItemClicked(diningRoomItem);
                }
            });
        }
    }

    public void setWheelerData(JsonMember2WheelersItem jsonMember2WheelersItem, String name) {
        if (name.equalsIgnoreCase("2 Wheeler")) {
            tvName.setText(jsonMember2WheelersItem.getName());
            tvOffer.setText(jsonMember2WheelersItem.getOffer());
            tvPrice.setText(jsonMember2WheelersItem.getMonthlyRental());
            // tvVariant.setText(jsonMember2WheelersItem.getVariants());
            Glide.with(ivImage).load(jsonMember2WheelersItem.getImageUrl()).into(ivImage);

            llProduct.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onTwoWheelerItemClicked(jsonMember2WheelersItem);
                }
            });
        }
    }

}


