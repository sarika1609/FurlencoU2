package com.example.furlenco.StartScreenFragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.furlenco.Activities.MainActivity;
import com.example.furlenco.Activities.HomeActivity;
import com.example.furlenco.CartPreferenceHelper;
import com.example.furlenco.R;

public class FragmentFive extends Fragment implements View.OnClickListener {
    MainActivity mainActivity;
    CardView cvBengaluru, cvMumbai, cvPune, cvDelhi, cvGurugram, cvNoida, cvHyderabad, cvChennai;

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
        cvChennai = view.findViewById(R.id.cvChennai);
        CartPreferenceHelper.getInstance(getContext());

        cvBengaluru.setOnClickListener(this);
        cvMumbai.setOnClickListener(this);
        cvPune.setOnClickListener(this);
        cvDelhi.setOnClickListener(this);
        cvGurugram.setOnClickListener(this);
        cvNoida.setOnClickListener(this);
        cvHyderabad.setOnClickListener(this);
        cvChennai.setOnClickListener(this);
    }

    public void launchHomeActivity(String name) {
        CartPreferenceHelper.WriteString("city_name",name);
        Intent intent = new Intent(getContext(), HomeActivity.class);
        intent.putExtra("city_name", name);
        startActivity(intent);

    }

    @Override
    public void onResume() {
        super.onResume();

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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cvBengaluru:
                launchHomeActivity("Bengaluru");
                break;
            case R.id.cvMumbai:
                launchHomeActivity("Mumbai");
                break;
            case R.id.cvPune:
                launchHomeActivity("Pune");
                break;
            case R.id.cvDelhi:
                launchHomeActivity("Delhi");
                break;
            case R.id.cvGurugram:
                launchHomeActivity("Gurugram");
                break;
            case R.id.cvNoida:
                launchHomeActivity("Noida");
                break;
            case R.id.cvHyderabad:
                launchHomeActivity("Hyderabad");
                break;
            case R.id.cvChennai:
                launchHomeActivity("Chennai");
                break;
        }
    }
}