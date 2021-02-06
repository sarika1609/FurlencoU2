package com.example.furlenco.LoginActivities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.furlenco.R;

public class OTPActivity extends AppCompatActivity {

    private EditText mEtFirstDigit, mEtSecondDigit, mEtThirdDigit, mEtFourthDigit;
    private Button mBtnVerify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_p);
        initViews();
    }

    private void initViews() {
        mEtFirstDigit = findViewById(R.id.etFirstNumber);
        mEtSecondDigit = findViewById(R.id.etSecondNumber);
        mEtThirdDigit = findViewById(R.id.etThirdNumber);
        mEtFourthDigit = findViewById(R.id.etFourthNumber);
        mBtnVerify = findViewById(R.id.btnVerify);

        mBtnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OTPActivity.this,PasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
        otpGenerator();
    }

    private void otpGenerator() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEtFirstDigit.setText("2");
                mEtSecondDigit.setText("6");
                mEtThirdDigit.setText("0");
                mEtFourthDigit.setText("5");
            }
        }, 2000);
    }

}