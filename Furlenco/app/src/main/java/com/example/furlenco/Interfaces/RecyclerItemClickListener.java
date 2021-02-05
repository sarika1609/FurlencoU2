package com.example.furlenco.Interfaces;

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
import com.example.furlenco.ProdcutsFragments.TwoWheelersFragment;

public interface RecyclerItemClickListener {
    void onLivingItemClicked(LivingRoomItem livingRoomItem);

    void onItemClicked(BedroomItem bedroomItem);

    void onApplianceItemClicked(AppliancesItem appliancesItem);

    void onFullHomeItemClicked(FullHomeItem fullHomeItem);

    void onStorageItemClicked(StorageItem storageItem);

    void onStudyRoomItemClicked(StudyRoomItem studyRoomItem);

    void onKidsItemClicked(KidsRoomItem kidsRoomItem);

    void onDiningItemClicked(DiningRoomItem diningRoomItem);

    void onTwoWheelerItemClicked(JsonMember2WheelersItem jsonMember2WheelersItem);

    void onSpecialOfferItemClicked(SpecialDealsItem specialDealsItem);


}
