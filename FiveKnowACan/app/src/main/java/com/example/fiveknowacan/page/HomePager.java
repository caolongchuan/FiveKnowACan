package com.example.fiveknowacan.page;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.fiveknowacan.base.BasePager;

/**
 * 物资详情页
 *
 * @author cao
 * @date 2019-8-20
 */
public class HomePager extends BasePager {

    public HomePager(Activity activity) {
        super(activity);
    }

    @Override
    public void initData() {
        System.out.println("首页初始化啦...");

        // 要给帧布局填充布局对象
        TextView view = new TextView(mActivity);
        view.setText("首页");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);

        flContent.addView(view);

        // 修改页面标题
        tvTitle.setText("智慧北京");

        // 隐藏菜单按钮
        btnMenu.setVisibility(View.GONE);
    }

}

