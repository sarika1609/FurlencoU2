package com.example.furlenco.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.Interfaces.LivingRoomItemClickListner;
import com.example.furlenco.Interfaces.RecyclerItemClickListener;
import com.example.furlenco.POJOClasses.AppliancesItem;
import com.example.furlenco.POJOClasses.BedroomItem;
import com.example.furlenco.POJOClasses.DiningRoomItem;
import com.example.furlenco.POJOClasses.ExploreProductsItem;
import com.example.furlenco.POJOClasses.FullHomeItem;
import com.example.furlenco.POJOClasses.JsonMember2WheelersItem;
import com.example.furlenco.POJOClasses.KidsRoomItem;
import com.example.furlenco.POJOClasses.LivingRoomItem;
import com.example.furlenco.POJOClasses.StorageItem;
import com.example.furlenco.POJOClasses.StudyRoomItem;
import com.example.furlenco.R;
import com.example.furlenco.ViewHolders.ProductViewHolder;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private RecyclerItemClickListener listener;
    private LivingRoomItemClickListner livingRoomItemClickListner;
    private List<BedroomItem> bedroomItemList;
    private List<ExploreProductsItem> exploreProductsItemList;
    String name;

    public ProductAdapter(RecyclerItemClickListener listener, List<ExploreProductsItem> exploreProductsItemList, String name) {
        this.listener = listener;
        this.exploreProductsItemList = exploreProductsItemList;
        this.name = name;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_layout, parent, false);
        return new ProductViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        if (exploreProductsItemList.get(0).getBedroom() != null) {
            BedroomItem bedroomItem = exploreProductsItemList.get(0).getBedroom().get(position);
            if (bedroomItem != null) {
                holder.setBedRoomData(bedroomItem, name);
            }
        }
        if (exploreProductsItemList.get(1).getLivingRoom() != null) {
            LivingRoomItem livingRoomItem = exploreProductsItemList.get(1).getLivingRoom().get(position);
            if (livingRoomItem != null) {
                holder.setLivingRoomData(livingRoomItem, name);
            }

        }
        if (exploreProductsItemList.get(2).getAppliances() != null) {
            AppliancesItem appliancesItem = exploreProductsItemList.get(2).getAppliances().get(position);
            if (appliancesItem != null) {
                holder.setApplianceRoomData(appliancesItem, name);
            }
        }
        if (exploreProductsItemList.get(3).getFullHome() != null) {
            FullHomeItem fullHomeItem = exploreProductsItemList.get(3).getFullHome().get(position);
            if (fullHomeItem != null) {
                holder.setFullRoomData(fullHomeItem, name);
            }
        }
       if (exploreProductsItemList.get(4).getStorage() != null) {
            StorageItem storageItem = exploreProductsItemList.get(4).getStorage().get(0);
            if (storageItem != null) {
                holder.setStorageData(storageItem, name);
            }
        }
        if (exploreProductsItemList.get(5).getStudyRoom() != null) {
            StudyRoomItem studyRoomItem = exploreProductsItemList.get(5).getStudyRoom().get(0);
            if (studyRoomItem != null) {
                holder.setStudhoyRoomData(studyRoomItem, name);
            }
        }

        if (exploreProductsItemList.get(6).getKidsRoom() != null) {
            KidsRoomItem kidsRoomItem = exploreProductsItemList.get(6).getKidsRoom().get(0);
            if (kidsRoomItem != null) {
                holder.setKidsRoomData(kidsRoomItem, name);
            }
        }

        if (exploreProductsItemList.get(7).getDiningRoom() != null) {
            DiningRoomItem diningRoomItem = exploreProductsItemList.get(7).getDiningRoom().get(0);
            if (diningRoomItem != null) {
                holder.setDiningRoomData(diningRoomItem, name);
            }
        }
        if (exploreProductsItemList.get(8).getJsonMember2Wheelers() != null &&exploreProductsItemList.get(8).getJsonMember2Wheelers().size()<1) {
            JsonMember2WheelersItem jsonMember2WheelersItem = exploreProductsItemList.get(8).getJsonMember2Wheelers().get(position);
            if (jsonMember2WheelersItem != null) {
                holder.setWheelerData(jsonMember2WheelersItem, name);
            }
        }
    }


    @Override
    public int getItemCount() {
        return exploreProductsItemList.size();
    }
}
