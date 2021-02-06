package com.example.furlenco.HomeScreenViewHolders;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.HomeScreenModelClasses.Curated;
import com.example.furlenco.HomeScreenModelClasses.Design;
import com.example.furlenco.HomeScreenModelClasses.Renting;
import com.example.furlenco.Interfaces.OnHomeFragmentItemPosition;
import com.example.furlenco.R;

public class RentingDescriptionViewHolder extends RecyclerView.ViewHolder {

    private TextView mTvHeader;
    private TextView mTvData;
    Button btnExplore;


    public RentingDescriptionViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvHeader = itemView.findViewById(R.id.tvHeader);
        mTvData = itemView.findViewById(R.id.tvData);
        btnExplore=itemView.findViewById(R.id.btnExplore);
    }

    public void setData(Renting renting) {
        mTvHeader.setText(renting.getHeaderText());
        mTvData.setText(renting.getData());
    }

    public void setDataForDesign(Design design) {
        mTvHeader.setText(design.getHeaderText());
        mTvData.setText(design.getData());

    }

    public void setDataForCurated(Curated curated) {
        mTvHeader.setText(curated.getHeaderText());
        mTvData.setText(curated.getData());
    }
}
