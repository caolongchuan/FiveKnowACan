package com.example.fiveknowacan.page;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fiveknowacan.R;
import com.example.fiveknowacan.activity.AboutUsActivity;
import com.example.fiveknowacan.activity.ChangePasswordActivity;
import com.example.fiveknowacan.base.BasePager;

import java.util.ArrayList;

/**
 * 我的页面
 *
 * @author cao
 * @date 2019-8-20
 */
public class MyPager extends BasePager {

    private TextView tv_PerName;
    private LinearLayout ll_ChangePass;
    private LinearLayout ll_FamilyAbout;
    private Button btn_Exit;

    public MyPager(Activity activity) {
        super(activity);
    }
    @Override
    public void initData() {
        System.out.println("我的初始化啦...");
        View view = View.inflate(mActivity, R.layout.pager_my, null);
        tv_PerName = view.findViewById(R.id.tv_person_name);
        ll_ChangePass = view.findViewById(R.id.linear_family_changepassword);
        ll_FamilyAbout = view.findViewById(R.id.linear_family_about);
        btn_Exit = view.findViewById(R.id.btn_exit);
        initEvent();
        flContent.addView(view);

        // 修改页面标题
        tvTitle.setText("我的");
        // 隐藏菜单按钮
        btnMenu.setVisibility(View.GONE);
    }

    //初始化点击事件
    private void initEvent(){
        tv_PerName.setText("诸葛亮");
        //修改密码
        ll_ChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.startActivity(new Intent(mActivity, ChangePasswordActivity.class));
//                mActivity.overridePendingTransition(0,R.anim.activity_open);
            }
        });
        //关于我们
        ll_FamilyAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.startActivity(new Intent(mActivity, AboutUsActivity.class));
//                mActivity.overridePendingTransition(R.anim.activity_open,R.anim.activity_open);
            }
        });
        //退出登录
        btn_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}