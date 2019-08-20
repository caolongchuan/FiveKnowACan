package com.example.fiveknowacan.base;

import android.app.Activity;
import android.view.View;

/**
 * 设备详情页基类
 *
 * @author cao
 * @date 2019-8-20
 */
public abstract class BaseDeviceDetialPager {

    public Activity mActivity;
    public View mRootView;// 设备详情页根布局

    public BaseDeviceDetialPager(Activity activity) {
        mActivity = activity;
        mRootView = initView();
    }

    // 初始化布局,必须子类实现
    public abstract View initView();

    // 初始化数据
    public void initData() {
        //具体初始化在子类中实现

    }

}
