package com.example.furlenco.HomeScreenViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.HomeScreenModelClasses.BrowseCollections;
import com.example.furlenco.R;

public class BrowseCollectionsViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvTag;
    private ImageView mIvBrowseImage;

    public BrowseCollectionsViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvTag = itemView.findViewById(R.id.tvTag);
        mIvBrowseImage = itemView.findViewById(R.id.ivBrowseImage);
    }

    public void setData(BrowseCollections browseCollections) {
        mIvBrowseImage.setImageResource(browseCollections.getImage());
        mTvTag.setText(browseCollections.getTag());
    }
}
