package com.example.fiveknowacan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.fiveknowacan.R;
import com.example.fiveknowacan.base.BaseActivity;

public class ChangePasswordActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_change_password);
        tvTitle.setText("修改密码");

    }


    @Override
    public void initData() {
        View view = View.inflate(this, R.layout.activity_change_password, null);
        flContent.addView(view);
    }
}
