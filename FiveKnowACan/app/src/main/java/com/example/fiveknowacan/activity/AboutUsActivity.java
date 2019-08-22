package com.example.fiveknowacan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.fiveknowacan.R;
import com.example.fiveknowacan.base.BaseActivity;
import com.example.fiveknowacan.base.BasePager;

public class AboutUsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tvTitle.setText("关于我们");
    }

    @Override
    public void initData() {
        View view = View.inflate(this, R.layout.activity_about_us, null);

        flContent.addView(view);
    }
}
