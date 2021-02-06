package com.example.furlenco.LoginActivities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.furlenco.R;

public class SignUpActivity extends AppCompatActivity {

    private EditText mEtYourName, mEtEmail, mEtMobile;
    private Button mBtnSignUp, mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initViews();
    }

    private void initViews() {
        mEtYourName = findViewById(R.id.etYourMobile);
        mEtMobile = findViewById(R.id.etMobile);
        mEtEmail = findViewById(R.id.etEmail);
        mBtnSignUp = findViewById(R.id.btnSignUp3);
        mBtnLogin = findViewById(R.id.btnLogin3);

        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,OTPActivity.class);
                intent.putExtra("name",mEtYourName.getText().toString());
                intent.putExtra("mobile",mEtYourName.getText().toString());
                intent.putExtra("email",mEtYourName.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}