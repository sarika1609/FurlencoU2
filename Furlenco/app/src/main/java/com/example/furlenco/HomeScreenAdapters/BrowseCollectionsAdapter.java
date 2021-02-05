package com.example.furlenco.HomeScreenAdapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.HomeScreenModelClasses.BrowseCollections;
import com.example.furlenco.R;
import com.example.furlenco.HomeScreenViewHolders.BrowseCollectionsViewHolder;

import java.util.List;

public class BrowseCollectionsAdapter extends RecyclerView.Adapter<BrowseCollectionsViewHolder> {

    private List<BrowseCollections> browseCollectionsList;

    public BrowseCollectionsAdapter(List<BrowseCollections> browseCollectionsList) {
        this.browseCollectionsList = browseCollectionsList;
    }

    @NonNull
    @Override
    public BrowseCollectionsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.broswe_collections_item_layout,parent,false);
        return new BrowseCollectionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrowseCollectionsViewHolder holder, int position) {
        BrowseCollections browseCollections = browseCollectionsList.get(position);
        holder.setData(browseCollections);

    }

    @Override
    public int getItemCount() {
        return browseCollectionsList.size();
    }
}
