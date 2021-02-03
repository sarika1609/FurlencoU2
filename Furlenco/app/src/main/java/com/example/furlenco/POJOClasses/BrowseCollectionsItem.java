package com.example.furlenco.POJOClasses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class BrowseCollectionsItem{

    @SerializedName("CRED Collection")
    private List<CREDCollectionItem> cREDCollection;

    @SerializedName("Award Winners")
    private List<AwardWinnersItem> awardWinners;

    @SerializedName("Storage Combo")
    private List<StorageComboItem> storageCombo;

    @SerializedName("New Launch")
    private List<NewLaunchItem> newLaunch;

    @SerializedName("Essentials")
    private List<EssentialsItem> essentials;

    @SerializedName("Most Popular")
    private List<MostPopularItem> mostPopular;

    @SerializedName("Vibrant Homes")
    private List<VibrantHomesItem> vibrantHomes;

    @SerializedName("Special Deals")
    private List<SpecialDealsItem> specialDeals;

    public List<CREDCollectionItem> getCREDCollection(){
        return cREDCollection;
    }

    public List<AwardWinnersItem> getAwardWinners(){
        return awardWinners;
    }

    public List<StorageComboItem> getStorageCombo(){
        return storageCombo;
    }

    public List<NewLaunchItem> getNewLaunch(){
        return newLaunch;
    }

    public List<EssentialsItem> getEssentials(){
        return essentials;
    }

    public List<MostPopularItem> getMostPopular(){
        return mostPopular;
    }

    public List<VibrantHomesItem> getVibrantHomes(){
        return vibrantHomes;
    }

    public List<SpecialDealsItem> getSpecialDeals(){
        return specialDeals;
    }
}