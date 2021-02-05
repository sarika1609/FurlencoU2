package com.example.furlenco.HomeScreenFragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furlenco.Activities.HomeActivity;
import com.example.furlenco.Adapters.ProductsAdapter;
import com.example.furlenco.HomeScreenAdapters.BrowseCollectionsAdapter;
import com.example.furlenco.HomeScreenAdapters.CuratedAdapter;
import com.example.furlenco.HomeScreenAdapters.DesignAdapter;
import com.example.furlenco.HomeScreenAdapters.RentingAdapter;
import com.example.furlenco.HomeScreenModelClasses.BrowseCollections;
import com.example.furlenco.HomeScreenModelClasses.Curated;
import com.example.furlenco.HomeScreenModelClasses.Design;
import com.example.furlenco.HomeScreenModelClasses.Renting;
import com.example.furlenco.Interfaces.OnProductClick;
import com.example.furlenco.POJOClasses.ResponseModel;
import com.example.furlenco.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements OnProductClick {

    RecyclerView rv_products, rv_collection, rvRentingIsAwesome, rvWeDesign, rvCuratedPackages, rvAwesomeServices;
    ResponseModel responseModel;
    private HomeActivity homeActivity;

    private List<BrowseCollections> browseCollectionsList;
    private List<Renting> rentingList;
    private List<Design> designList;
    private List<Curated> curatedList;

    private Runnable apiRunnable = new Runnable() {
        @Override
        public void run() {
            getDataFromJson();
        }
    };

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        rv_products = view.findViewById(R.id.rv_products);
        rv_collection = view.findViewById(R.id.rv_collection);
        createPOJO();
        bindCollectionData();
        setCollectionRecyclerData();
        bindRentingData();
        setRentingRecyclerData();
        bindDesignData();
        setDesignRecyclerData();
        bindCuratedData();
        setCuratedRecyclerData();
        bindAwesomeData();
        setAwesomeRecyclerData();
    }

    private void setAwesomeRecyclerData() {

    }

    private void bindAwesomeData() {

    }

    private void setCuratedRecyclerData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvCuratedPackages.setLayoutManager(linearLayoutManager);
        CuratedAdapter adapter = new CuratedAdapter(curatedList);
        rvCuratedPackages.setAdapter(adapter);
    }

    private void bindCuratedData() {
        curatedList = new ArrayList<>();
        curatedList.add(new Curated(R.drawable.vibrent,"","",Curated.ITEM_TYPE_IMAGE));
        curatedList.add(new Curated(0,"Curated\nPackages",getString(R.string.text_just_furniture),Curated.ITEM_TYPE_DESC));
        curatedList.add(new Curated(0,"Living\nRoom",getString(R.string.text_living_room),Curated.ITEM_TYPE_DESC));
        curatedList.add(new Curated(0,"Bedroom",getString(R.string.text_bedroom),Curated.ITEM_TYPE_DESC));
        curatedList.add(new Curated(0,"Appliances",getString(R.string.text_appliances),Curated.ITEM_TYPE_DESC));

    }

    private void setDesignRecyclerData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvWeDesign.setLayoutManager(linearLayoutManager);
        DesignAdapter adapter = new DesignAdapter(designList);
        rvWeDesign.setAdapter(adapter);
    }

    private void bindDesignData() {
        designList = new ArrayList<>();
        designList.add(new Design(R.drawable.new_launch, "", "", Design.ITEM_TYPE_IMAGE));
        designList.add(new Design(0, "We Design for\nYOU", getString(R.string.text_our_designs_are), Design.ITEM_TYPE_DESC));
    }

    private void setRentingRecyclerData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvRentingIsAwesome.setLayoutManager(linearLayoutManager);
        RentingAdapter adapter = new RentingAdapter(rentingList);
        rvRentingIsAwesome.setAdapter(adapter);
    }

    private void bindRentingData() {
        rentingList = new ArrayList<>();
        rentingList.add(new Renting(R.drawable.most_popular, "", "", Renting.ITEM_TYPE_IMAGE));
        rentingList.add(new Renting(0, "Live Better.\nNow.", getString(R.string.text_awrd_winning), Renting.ITEM_TYPE_DESC));
        rentingList.add(new Renting(0, "Have everything,\nwithout buying.", getString(R.string.text_bed_or_sofa), Renting.ITEM_TYPE_DESC));
        rentingList.add(new Renting(0, "Change as your\nneeds evolve", getString(R.string.text_upgrade), Renting.ITEM_TYPE_DESC));

    }

    private void initViews(View view) {
        rv_products = view.findViewById(R.id.rv_products);
        rv_collection = view.findViewById(R.id.rv_collection);
        rvRentingIsAwesome = view.findViewById(R.id.rvRentingIsAwesome);
        rvWeDesign = view.findViewById(R.id.rvWeDesign);
        rvCuratedPackages = view.findViewById(R.id.rvCuratedPackages);
        rvAwesomeServices = view.findViewById(R.id.rvAwesomeServices);
    }

    private void bindCollectionData() {
        browseCollectionsList = new ArrayList<>();

        browseCollectionsList.add(new BrowseCollections(R.drawable.new_launch, "Newly Launched Products."));
        browseCollectionsList.add(new BrowseCollections(R.drawable.vibrent, "Keep the festive spirit high."));
        browseCollectionsList.add(new BrowseCollections(R.drawable.most_popular, "Most loved and rented collection."));
        browseCollectionsList.add(new BrowseCollections(R.drawable.storage, "Storage solutions for your home."));

    }

    private void setCollectionRecyclerData() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rv_collection.setLayoutManager(linearLayoutManager);
        BrowseCollectionsAdapter adapter = new BrowseCollectionsAdapter(browseCollectionsList);
        rv_collection.setAdapter(adapter);
    }

    private void createPOJO() {
        Thread thread = new Thread(apiRunnable);
        thread.start();
    }

    private void getDataFromJson() {
        InputStream inputStream = null;
        try {
            inputStream = getActivity().getAssets().open("response.json");
            int data = inputStream.read();
            StringBuffer stringBuffer = new StringBuffer();
            while (data != -1) {
                char ch = (char) data;
                stringBuffer.append(ch);
                data = inputStream.read();
            }

            buildPOJOFromJSON(stringBuffer.toString());

        } catch (Exception e) {
            Log.d("Tag", e.getMessage());
        }

    }

    private void buildPOJOFromJSON(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<ResponseModel>() {
        }.getType();
        ResponseModel responseModel = gson.fromJson(json, type);
        setData(responseModel);
    }

    private void setData(ResponseModel responseModel) {
        this.responseModel = responseModel;
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
                rv_products.setLayoutManager(gridLayoutManager);
                ProductsAdapter productsAdapter = new ProductsAdapter(responseModel.getExploreProducts(), HomeFragment.this::productItemClicked);
                rv_products.setAdapter(productsAdapter);


            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        homeActivity = (HomeActivity) context;
    }

    @Override
    public void productItemClicked(int position) {
        if (homeActivity != null) {
            homeActivity.sendingAdapterPosition(position);
        }
    }


}