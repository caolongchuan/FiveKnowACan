package com.example.fiveknowacan.page;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.fiveknowacan.activity.MainActivity;
import com.example.fiveknowacan.activity.StartScanActivity;
import com.example.fiveknowacan.base.BaseDeviceDetialPager;
import com.example.fiveknowacan.base.BasePager;
import com.example.fiveknowacan.bean.DeviceClassifiBean;
import com.example.fiveknowacan.fragment.LeftMenuFragment;
import com.example.fiveknowacan.global.GlobalConstants;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;

import java.util.ArrayList;

/**
 * 物资设备详情页
 *
 * @author cao
 * @date 2019-8-20
 */
public class DevicePager extends BasePager {

    private ArrayList<BaseDeviceDetialPager> mDeviceDetailPagers;// 菜单详情页集合

    private ArrayList<DeviceClassifiBean> mDeviceClassifiData = new ArrayList<>();// 分类信息网络数据


    public DevicePager(Activity activity) {
        super(activity);
        //先给点假数据
        initDeviceClassifi();

        initEvent();
    }

    private void initEvent() {
        //点击扫描按钮
        btnScanning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mActivity, StartScanActivity.class);
                mActivity.startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        // 修改页面标题
        tvTitle.setText("设备列表");
        // 显示菜单按钮
        btnMenu.setVisibility(View.VISIBLE);
        //将搜素与扫描按钮显示出来
        llSearchScanning.setVisibility(View.VISIBLE);
        // 获取侧边栏对象
        MainActivity mainUI = (MainActivity) mActivity;
        LeftMenuFragment fragment = mainUI.getLeftMenuFragment();
        // 给侧边栏设置数据
        fragment.setMenuData(mDeviceClassifiData);

/*
        // 要给帧布局填充布局对象
        TextView view = new TextView(mActivity);
        view.setText("设备页");
        view.setTextColor(Color.RED);
        view.setTextSize(22);
        view.setGravity(Gravity.CENTER);
        //给设备详情页添加数据
        flContent.addView(view);
*/

        getDataFromServer();
    }

    //临时用 假数据
    private void initDeviceClassifi() {
        DeviceClassifiBean dcb0=new DeviceClassifiBean(0,"防护类");
        DeviceClassifiBean dcb1=new DeviceClassifiBean(1,"侦检类");
        DeviceClassifiBean dcb2=new DeviceClassifiBean(2,"洗消类");
        mDeviceClassifiData.add(dcb0);
        mDeviceClassifiData.add(dcb1);
        mDeviceClassifiData.add(dcb2);

        // 初始化1个设备列表详情页
        mDeviceDetailPagers = new ArrayList<BaseDeviceDetialPager>();
        mDeviceDetailPagers.add(new AllDeviceListPager(mActivity));
        // 将新闻菜单详情页设置为默认页面
        setCurrentDetailPager(0);

    }


    // 设置为全部详情页
    public void setCurrentDetailPager(int position) {
        // 重新给frameLayout添加内容
        BaseDeviceDetialPager pager = mDeviceDetailPagers.get(position);// 获取当前应该显示的页面
        View view = pager.mRootView;// 当前页面的布局

        // 清除之前旧的布局
        flContent.removeAllViews();

        flContent.addView(view);// 给帧布局添加布局

        // 初始化页面数据
        pager.initData();

        // 更新标题
        tvTitle.setText("全部设备");

    }

    /**
     * 从服务器获取数据 需要权限:<uses-permission android:name="android.permission.INTERNET"
     * />
     */
    private void getDataFromServer() {
        HttpUtils utils = new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, GlobalConstants.CATEGORY_URL,
                new RequestCallBack<String>() {

                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        // 请求成功
                        String result = responseInfo.result;// 获取服务器返回结果
                        System.out.println("服务器返回结果:" + result);

                        // JsonObject, Gson
//                        processData(result);

                        // 写缓存
//                        CacheUtils.setCache(GlobalConstants.CATEGORY_URL,
//                                result, mActivity);
                    }

                    @Override
                    public void onFailure(HttpException error, String msg) {
                        // 请求失败
                        error.printStackTrace();
                        Toast.makeText(mActivity, msg, Toast.LENGTH_SHORT)
                                .show();
                    }
                });
    }


}

