package com.example.furlenco.LoginActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.furlenco.R;

public class LoginActivity extends AppCompatActivity {

    private Button mBtnNext, mBtnSignUp;
    private EditText mEtNameOrEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    private void initViews() {
        mBtnNext = findViewById(R.id.btnNext);
        mBtnSignUp = findViewById(R.id.btnSignUp2);
        mEtNameOrEmail = findViewById(R.id.etYourMobile2);

        mBtnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, LoginActivityWithPassword.class);
                intent.putExtra("id", mEtNameOrEmail.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}