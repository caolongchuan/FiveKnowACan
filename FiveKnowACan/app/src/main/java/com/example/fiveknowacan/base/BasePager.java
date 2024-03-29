package com.example.fiveknowacan.base;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fiveknowacan.activity.MainActivity;
import com.example.fiveknowacan.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

/**
 * 两个标签页的基类 1内容详情 2我的
 *
 * @author cao
 * @date 2019-8-20
 */
public class BasePager {

    public Activity mActivity;

    public RelativeLayout rlMyActionBar;
    public TextView tvTitle;
    public ImageButton btnMenu;
    public FrameLayout flContent;// 空的帧布局对象, 要动态添加布局

    public ImageButton btnPhoto;//组图切换按钮
    public LinearLayout llSearchScanning;  //搜索与扫描
    public ImageButton btnSearch;//搜索
    public ImageButton btnScanning;//扫描

    public View mRootView;// 当前页面的布局对象

    public BasePager(Activity activity) {
        mActivity = activity;
        mRootView = initView();
    }

    // 初始化布局
    public View initView() {
        View view = View.inflate(mActivity, R.layout.base_pager, null);
        rlMyActionBar = view.findViewById(R.id.rl_myactionbar);
        tvTitle = (TextView) view.findViewById(R.id.tv_title);
        btnMenu = (ImageButton) view.findViewById(R.id.btn_menu);
        btnPhoto = (ImageButton) view.findViewById(R.id.btn_photo);
        flContent = (FrameLayout) view.findViewById(R.id.fl_content);
        llSearchScanning=view.findViewById(R.id.ll_control);
        btnSearch = view.findViewById(R.id.btn_search);
        btnScanning = view.findViewById(R.id.btn_scanning);
        btnMenu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                toggle();
            }
        });

        return view;
    }

    /**
     * 打开或者关闭侧边栏
     */
    protected void toggle() {
        MainActivity mainUI = (MainActivity) mActivity;
        SlidingMenu slidingMenu = mainUI.getSlidingMenu();
        slidingMenu.toggle();// 如果当前状态是开, 调用后就关; 反之亦然
    }

    // 初始化数据
    public void initData() {

    }
}

