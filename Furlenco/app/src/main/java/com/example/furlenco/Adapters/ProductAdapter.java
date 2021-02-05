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
import com.example.furlenco.ProdcutsFragments.AppliancesFragment;
import com.example.furlenco.ProdcutsFragments.BedroomFragment;
import com.example.furlenco.ProdcutsFragments.DiningRoomFragment;
import com.example.furlenco.ProdcutsFragments.FullHomeFragment;
import com.example.furlenco.ProdcutsFragments.KidsRoomFragment;
import com.example.furlenco.ProdcutsFragments.LivingRoomFragment;
import com.example.furlenco.ProdcutsFragments.SpecialDealsFragment;
import com.example.furlenco.ProdcutsFragments.StorageFragment;
import com.example.furlenco.ProdcutsFragments.StudyRoomFragment;
import com.example.furlenco.ProdcutsFragments.TwoWheelersFragment;
import com.example.furlenco.R;
import com.example.furlenco.ViewHolders.ProductViewHolder;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private RecyclerItemClickListener listener;
    private List<ExploreProductsItem> exploreProductsItemList = new ArrayList<>();
    ;
    private List<JsonMember2WheelersItem> jsonMember2WheelersItemList = new ArrayList<>();
    private List<BedroomItem> bedroomItemList = new ArrayList<>();
    private List<LivingRoomItem> livingRoomItemList = new ArrayList<>();
    private List<AppliancesItem> appliancesItemList = new ArrayList<>();
    private List<FullHomeItem> fullHomeItemList = new ArrayList<>();
    private List<StorageItem> storageItemList = new ArrayList<>();
    private List<StudyRoomItem> studyRoomItemList = new ArrayList<>();
    private List<KidsRoomItem> kidsRoomItemList = new ArrayList<>();
    private List<DiningRoomItem> diningRoomItemList = new ArrayList<>();


    String name;


    public ProductAdapter(BedroomFragment listener, List<BedroomItem> bedroom, String bed_room) {
        this.listener = listener;
        this.bedroomItemList = bedroom;
        this.name = bed_room;
    }

    public ProductAdapter(LivingRoomFragment listener, List<LivingRoomItem> livingRoom, String living_room) {
        this.listener = listener;
        this.livingRoomItemList = livingRoom;
        this.name = living_room;
    }

    public ProductAdapter(AppliancesFragment listener, List<AppliancesItem> appliances, String appliance_room) {
        this.listener = listener;
        this.appliancesItemList = appliances;
        this.name = appliance_room;
    }

    public ProductAdapter(FullHomeFragment listener, List<FullHomeItem> fullHome, String full_room) {
        this.listener = listener;
        this.fullHomeItemList = fullHome;
        this.name = full_room;
    }

    public ProductAdapter(StorageFragment listener, List<StorageItem> storage, String storage_room) {
        this.listener = listener;
        this.storageItemList = storage;
        this.name = storage_room;
    }

    public ProductAdapter(StudyRoomFragment listener, List<StudyRoomItem> studyRoom, String study_room) {
        this.listener = listener;
        this.studyRoomItemList = studyRoom;
        this.name = study_room;
    }

    public ProductAdapter(KidsRoomFragment listener, List<KidsRoomItem> kidsRoom, String kids_room) {
        this.listener = listener;
        this.kidsRoomItemList = kidsRoom;
        this.name = kids_room;
    }

    public ProductAdapter(DiningRoomFragment listener, List<DiningRoomItem> diningRoom, String dining_room) {
        this.listener = listener;
        this.diningRoomItemList = diningRoom;
        this.name = dining_room;

    }

    public ProductAdapter(TwoWheelersFragment listener, List<JsonMember2WheelersItem> jsonMember2Wheelers, String name) {
        this.listener = listener;
        this.jsonMember2WheelersItemList = jsonMember2Wheelers;
        this.name = name;
    }

    public ProductAdapter(SpecialDealsFragment listener, List<BedroomItem> bedroom, String name) {
        this.listener = listener;
        this.bedroomItemList = bedroom;
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

        if (bedroomItemList.size() > 0) {
            BedroomItem bedroomItem = bedroomItemList.get(position);
            if (bedroomItem != null) {
                holder.setBedRoomData(bedroomItem, name);
                holder.setBedRoomData(bedroomItem,name);
            }
        } else if (livingRoomItemList.size() > 0) {
            LivingRoomItem livingRoomItem = livingRoomItemList.get(position);
            if (livingRoomItem != null) {
                holder.setLivingRoomData(livingRoomItem, name);
            }

        } else if (appliancesItemList.size() > 0) {
            AppliancesItem appliancesItem = appliancesItemList.get(position);
            if (appliancesItem != null) {
                holder.setApplianceRoomData(appliancesItem, name);
            }
        } else if (fullHomeItemList.size() > 0) {
            FullHomeItem fullHomeItem = fullHomeItemList.get(position);
            if (fullHomeItem != null) {
                holder.setFullRoomData(fullHomeItem, name);
            }
        } else if (storageItemList.size() > 0) {
            StorageItem storageItem = storageItemList.get(position);
            if (storageItem != null) {
                holder.setStorageData(storageItem, name);
            }
        } else if (studyRoomItemList.size() > 0) {
            StudyRoomItem studyRoomItem = studyRoomItemList.get(position);
            if (studyRoomItem != null) {
                holder.setStudhoyRoomData(studyRoomItem, name);
            }
        } else if (kidsRoomItemList.size() > 0) {
            KidsRoomItem kidsRoomItem = kidsRoomItemList.get(position);
            if (kidsRoomItem != null) {
                holder.setKidsRoomData(kidsRoomItem, name);
            }
        } else if (diningRoomItemList.size() > 0) {
            DiningRoomItem diningRoomItem = diningRoomItemList.get(0);
            if (diningRoomItem != null) {
                holder.setDiningRoomData(diningRoomItem, name);
            }
        } else if (jsonMember2WheelersItemList.size() > 0) {
            JsonMember2WheelersItem jsonMember2WheelersItem = jsonMember2WheelersItemList.get(position);
            holder.setWheelerData(jsonMember2WheelersItem, name);
        }

    }


    @Override
    public int getItemCount() {
        if (jsonMember2WheelersItemList.size() > 0) {
            return jsonMember2WheelersItemList.size();
        }
        if (diningRoomItemList.size() > 0) {
            return diningRoomItemList.size();
        }
        if (kidsRoomItemList.size() > 0) {
            return kidsRoomItemList.size();
        }
        if (studyRoomItemList.size() > 0) {
            return studyRoomItemList.size();
        }
        if (storageItemList.size() > 0) {
            return storageItemList.size();
        }
        if (fullHomeItemList.size() > 0) {
            return fullHomeItemList.size();
        }
        if (appliancesItemList.size() > 0) {
            return appliancesItemList.size();
        }
        if (livingRoomItemList.size() > 0) {
            return livingRoomItemList.size();
        }
        if (bedroomItemList.size() > 0) {
            return bedroomItemList.size();
        }
        return 0;
    }
}
