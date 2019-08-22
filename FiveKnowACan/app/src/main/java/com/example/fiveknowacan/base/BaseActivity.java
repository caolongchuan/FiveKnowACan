package com.example.fiveknowacan.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.fiveknowacan.R;

public class BaseActivity extends AppCompatActivity {

    public TextView tvTitle;
    public ImageButton btnMenu;
    public FrameLayout flContent;// 空的帧布局对象, 要动态添加布局

    public ImageButton btnPhoto;//组图切换按钮

    public View mRootView;// 当前页面的布局对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        // 必须在setContentView之前调用

        setContentView(R.layout.activity_base);

        initView();
        initData();
    }



    // 初始化布局
    public void initView() {
        tvTitle = (TextView) findViewById(R.id.tv_title);
        btnMenu = (ImageButton) findViewById(R.id.btn_menu);
        btnPhoto = (ImageButton) findViewById(R.id.btn_photo);
        flContent = (FrameLayout) findViewById(R.id.fl_content);
        btnMenu.setImageResource(R.mipmap.back_arrow);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    // 初始化数据
    public void initData() {
    }

    //重写finish方法实现打开与关闭的动画
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0,R.anim.activity_close);
    }
}
