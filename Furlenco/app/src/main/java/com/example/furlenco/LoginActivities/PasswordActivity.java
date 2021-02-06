package com.example.furlenco.LoginActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.furlenco.R;

public class PasswordActivity extends AppCompatActivity {

    private Button mBtnSet, mBtnSetLater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        initViews();
    }

    private void initViews() {
        mBtnSet = findViewById(R.id.btnSet);
        mBtnSetLater = findViewById(R.id.btnSetLater);

        mBtnSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBtnSetLater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}