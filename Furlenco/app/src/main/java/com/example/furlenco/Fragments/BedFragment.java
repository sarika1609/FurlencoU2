package com.example.furlenco.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.furlenco.Activities.HomeActivity;
import com.example.furlenco.Activities.MainActivity;
import com.example.furlenco.Adapters.ProductsAdapter;
import com.example.furlenco.ModelClasses.ProductModelClass;
import com.example.furlenco.R;

import java.util.ArrayList;
import java.util.List;


public class BedFragment extends Fragment {
    RecyclerView rv_beds;
    HomeActivity homeActivity;
    List<ProductModelClass> productModelClassList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bed, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    private void initUI(View view) {
        rv_beds = view.findViewById(R.id.rv_beds);
        bindBedsData();
        setBedsData();
    }

    private void setBedsData() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rv_beds.setLayoutManager(gridLayoutManager);
        ProductsAdapter productsAdapter = new ProductsAdapter(productModelClassList);
        rv_beds.setAdapter(productsAdapter);
    }

    private void bindBedsData() {
        for (int i = 0; i < 11; i++) {
            if (i == 0) {
                productModelClassList.add(new ProductModelClass(R.string.bedroom, "https://www.roomtogrow.co.uk/app/uploads/2019/01/595e583a5310c7.02846680.jpg"));
            }
            if (i == 1) {
                productModelClassList.add(new ProductModelClass(R.string.living_room, "http://storage.sg.content-cdn.io/cdn-cgi/image/%7Bwidth%7D,%7Bheight%7D,quality=75,format=auto/in-resources/407e79ae-b096-4e8d-8e8f-44f6fc5ec664/Images/ProductImages/Source/DOLCE_SOFA_BED_3_STR_WITH_STRG-BLUE_FLIL3SFBMTBU68396I(1).jpg"));
            }
            if (i == 2) {
                productModelClassList.add(new ProductModelClass(R.string.appliances, "https://akm-img-a-in.tosshub.com/indiatoday/images/story/202005/Realme_TV_43.png?VG_jgjLl9qx9Z1m5GOMla1iDBjR33k0s&size=770:433"));
            }
            if (i == 3) {
                productModelClassList.add(new ProductModelClass(R.string.full_home, "https://www.mydomaine.com/thmb/XK-lMVvrDonUoG2D1kAifowLGA8=/1001x700/filters:no_upscale():max_bytes(150000):strip_icc()/cdn.cliqueinc.com__cache__posts__265350__simple-bedroom-ideas-265350-1534284883385-image.700x0c-aee31323f7ee489c84d1df1b6055c7b1-e50b777800e04e3d9d557a05dfd4489d.jpg"));
            }
            if (i == 4) {
                productModelClassList.add(new ProductModelClass(R.string.storage, "https://ph-test-11.slatic.net/p/7490716902077ed38ac91aa3f8b3ec1e.jpg"));
            }
            if (i == 5) {
                productModelClassList.add(new ProductModelClass(R.string.study_room, "https://ae01.alicdn.com/kf/Hbb873be6975743c7bca9c91866240cf4V/Computer-desk-study-table-Nordic-office-desk-Modern-Europe-student-bedroom-study-desk-office-furniture-small.jpg_q50.jpg"));
            }
            if (i == 6) {
                productModelClassList.add(new ProductModelClass(R.string.kids_room, "https://www.littletreehouseapps.com/blog/wp-content/uploads/2019/11/kid-activities1.jpg"));
            }
            if (i == 7) {
                productModelClassList.add(new ProductModelClass(R.string.dining_room, "https://5.imimg.com/data5/KO/OF/MY-13174824/school-furniture-assembly-services-500x500.jpg"));
            }
            if (i == 8) {
                productModelClassList.add(new ProductModelClass(R.string.two_wheelers, "https://5.imimg.com/data5/SY/SV/ZT/GLADMIN-10494303/selection-014-500x500.png"));
            }
        }

    }

    public static BedFragment newInstance() {
        BedFragment bedFragment = new BedFragment();
        return bedFragment;
    }

}