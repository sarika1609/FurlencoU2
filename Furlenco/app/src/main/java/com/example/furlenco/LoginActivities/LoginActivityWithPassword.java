package com.example.furlenco.LoginActivities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.furlenco.R;

public class LoginActivityWithPassword extends AppCompatActivity {

    String id;
    private EditText mEtPhoneNumber;
    private Button mBtnLogin, mBtnUsingOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_with_password);
        if (getIntent() != null && getIntent().getExtras() != null) {
            id = getIntent().getStringExtra("id");
        }
        initViews();
    }

    private void initViews() {
        mBtnLogin = findViewById(R.id.btnLogin2);
        mBtnUsingOtp = findViewById(R.id.btnUsingOtp);
        mEtPhoneNumber = findViewById(R.id.etPhoneNumber2);

        mEtPhoneNumber.setText(id);

        mBtnUsingOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}