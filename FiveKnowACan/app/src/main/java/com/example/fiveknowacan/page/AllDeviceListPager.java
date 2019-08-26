package com.example.fiveknowacan.page;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.fiveknowacan.R;
import com.example.fiveknowacan.activity.DeviceDetialActivity;
import com.example.fiveknowacan.base.BaseDeviceDetialPager;
import com.example.fiveknowacan.bean.DeviceBean;

import java.util.ArrayList;

/**
 * 全部设备列表页
 *
 * @author cao
 * @date 2019-8-20
 */
class AllDeviceListPager extends BaseDeviceDetialPager {

    private ArrayList<DeviceBean> m_Device = new ArrayList<>();
    ListView m_lvDeviceList;
    DeviceAdapter m_Adapter;

    public AllDeviceListPager(Activity mActivity) {
        super(mActivity);
    }

    @Override
    public View initView() {

        View view = View.inflate(mActivity, R.layout.pager_all_device_detail,
                null);
//        ViewUtils.inject(this, view);
        m_lvDeviceList = view.findViewById(R.id.lv_devicelist);
        m_lvDeviceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mActivity.startActivity(new Intent(mActivity, DeviceDetialActivity.class));

            }
        });
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        //实验
        for(int i=0;i<10;i++){
            DeviceBean db = new DeviceBean();
            db.id = i;
            db.name = "消防斧";
            db.classifition = 0;
            db.use = "用途：用来砍东西";
            db.amount = 10;
            m_Device.add(db);
        }
        m_Adapter = new DeviceAdapter();
        m_lvDeviceList.setAdapter(m_Adapter);
    }







    class DeviceAdapter extends BaseAdapter {

//        private BitmapUtils mBitmapUtils;
        //private MyBitmapUtils mBitmapUtils;

        public DeviceAdapter() {
//            mBitmapUtils = new BitmapUtils(mActivity);
//            mBitmapUtils.configDefaultLoadingImage(R.drawable.news_pic_default);
            //mBitmapUtils = new MyBitmapUtils();
        }

        @Override
        public int getCount() {
            return m_Device.size();
        }

        @Override
        public DeviceBean getItem(int position) {
            return m_Device.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = View.inflate(mActivity, R.layout.list_item_news,
                        null);
                holder = new ViewHolder();
                holder.ivIcon = (ImageView) convertView
                        .findViewById(R.id.iv_icon);
                holder.tvTitle = (TextView) convertView
                        .findViewById(R.id.tv_title);
                holder.tvDate = (TextView) convertView
                        .findViewById(R.id.tv_date);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            DeviceBean b = getItem(position);
            holder.tvTitle.setText(b.name);
            holder.tvDate.setText(b.use);

            return convertView;
        }

    }

    static class ViewHolder {
        public ImageView ivIcon;
        public TextView tvTitle;
        public TextView tvDate;
    }





}
