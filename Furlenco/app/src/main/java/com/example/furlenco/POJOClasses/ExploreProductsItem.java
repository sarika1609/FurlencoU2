package com.example.furlenco.POJOClasses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ExploreProductsItem{

    @SerializedName("Special Deals")
    private List<SpecialDealsItem> specialDeals;

    @SerializedName("name")
    private String name;

    @SerializedName("image url")
    private String imageUrl;

    @SerializedName("id")
    private Integer id;

    @SerializedName("2-Wheelers")
    private List<JsonMember2WheelersItem> jsonMember2Wheelers;

    @SerializedName("Dining Room")
    private List<DiningRoomItem> diningRoom;

    @SerializedName("Kids Room")
    private List<KidsRoomItem> kidsRoom;

    @SerializedName("Study Room")
    private List<StudyRoomItem> studyRoom;

    @SerializedName("Storage")
    private List<StorageItem> storage;

    @SerializedName("Full Home")
    private List<FullHomeItem> fullHome;

    @SerializedName("Appliances")
    private List<AppliancesItem> appliances;

    @SerializedName("Living Room")
    private List<LivingRoomItem> livingRoom;

    @SerializedName("Bedroom")
    private List<BedroomItem> bedroom;

    public List<SpecialDealsItem> getSpecialDeals(){
        return specialDeals;
    }

    public String getName(){
        return name;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public Integer getId(){
        return id;
    }

    public List<JsonMember2WheelersItem> getJsonMember2Wheelers(){
        return jsonMember2Wheelers;
    }

    public List<DiningRoomItem> getDiningRoom(){
        return diningRoom;
    }

    public List<KidsRoomItem> getKidsRoom(){
        return kidsRoom;
    }

    public List<StudyRoomItem> getStudyRoom(){
        return studyRoom;
    }

    public List<StorageItem> getStorage(){
        return storage;
    }

    public List<FullHomeItem> getFullHome(){
        return fullHome;
    }

    public List<AppliancesItem> getAppliances(){
        return appliances;
    }

    public List<LivingRoomItem> getLivingRoom(){
        return livingRoom;
    }

    public List<BedroomItem> getBedroom(){
        return bedroom;
    }
}