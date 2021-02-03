package com.example.furlenco.POJOClasses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseModel{

	@SerializedName("Explore Products")
	private List<ExploreProductsItem> exploreProducts;

	@SerializedName("Award Winning Designs")
	private List<AwardWinningDesignsItem> awardWinningDesigns;

	@SerializedName("Browse Collections")
	private List<BrowseCollectionsItem> browseCollections;

	public List<ExploreProductsItem> getExploreProducts(){
		return exploreProducts;
	}

	public List<AwardWinningDesignsItem> getAwardWinningDesigns(){
		return awardWinningDesigns;
	}

	public List<BrowseCollectionsItem> getBrowseCollections(){
		return browseCollections;
	}
}