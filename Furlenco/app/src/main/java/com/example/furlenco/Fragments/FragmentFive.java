package com.example.furlenco.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.furlenco.Activities.HomeActivity;
import com.example.furlenco.Activities.MainActivity;
import com.example.furlenco.R;

public class FragmentFive extends Fragment {
    MainActivity mainActivity;
    CardView cvBengaluru, cvMumbai, cvPune, cvDelhi, cvGurugram, cvNoida, cvHyderabad, cvCennai;

    public static FragmentFive newInstance() {
        FragmentFive fragmentFive = new FragmentFive();
        return fragmentFive;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_five, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
    }

    private void initUI(View view) {
        cvBengaluru = view.findViewById(R.id.cvBengaluru);
        cvMumbai = view.findViewById(R.id.cvMumbai);
        cvPune = view.findViewById(R.id.cvPune);
        cvDelhi = view.findViewById(R.id.cvDelhi);
        cvGurugram = view.findViewById(R.id.cvGurugram);
        cvNoida = view.findViewById(R.id.cvNoida);
        cvHyderabad = view.findViewById(R.id.cvHyderabad);
        cvCennai = view.findViewById(R.id.cvCennai);

        cvBengaluru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHomeActivity("Bengaluru");
            }
        });
        cvMumbai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHomeActivity("Mumbai");
            }
        });

        cvPune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHomeActivity("Pune");
            }
        });
        cvDelhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHomeActivity("Delhi");
            }
        });
        cvGurugram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHomeActivity("Gurugram");
            }
        });
        cvNoida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHomeActivity("Noida");
            }
        });
        cvHyderabad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHomeActivity("Hyderabad");
            }
        });
        cvCennai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHomeActivity("Chennai");
            }
        });
    }

    public void gotoHomeActivity(String name) {
        Intent intent = new Intent(getContext(), HomeActivity.class);
        intent.putExtra("city_name", name);
        startActivity(intent);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

}