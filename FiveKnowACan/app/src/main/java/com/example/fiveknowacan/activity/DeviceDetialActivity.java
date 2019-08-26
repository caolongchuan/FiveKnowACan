package com.example.fiveknowacan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.fiveknowacan.R;
import com.example.fiveknowacan.base.BaseActivity;

import java.util.ArrayList;

public class DeviceDetialActivity extends BaseActivity {

    ScrollView mContainer;
    ListView mVadioList;
    ArrayList<String> vadio = new ArrayList<>();
    Button mPlayVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_device);
        tvTitle.setText("设备详情页");
        initEvent();
    }

    private void initEvent() {
        mPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DeviceDetialActivity.this,PlayVideoActivity.class));
            }
        });
    }

    @Override
    public void initData() {
        View view = View.inflate(this, R.layout.activity_device, null);
        mContainer = view.findViewById(R.id.sv_container);
        mVadioList = view.findViewById(R.id.lv_vadiolist);
        mPlayVideo = view.findViewById(R.id.btn_playvideo);
        flContent.addView(view);

        for (int i = 0; i < 10; i++) {
            vadio.add("这些都是视频");
        }
        myAdapter adapter = new myAdapter();
        mVadioList.setAdapter(adapter);
        setListViewHeightBasedOnChildren(mVadioList);
        mContainer.smoothScrollTo(0,0);
    }


    public class myAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return vadio.size();
        }

        @Override
        public Object getItem(int i) {
            return vadio.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            DeviceDetialActivity.ViewHolder holder;
            if (view == null) {
                view = View.inflate(DeviceDetialActivity.this, R.layout.list_device_video,
                        null);
                holder = new DeviceDetialActivity.ViewHolder();
                holder.tvVideo = view.findViewById(R.id.tv_video);
                view.setTag(holder);
            } else {
                holder = (DeviceDetialActivity.ViewHolder) view.getTag();
            }

            String b = (String) getItem(i);
            holder.tvVideo.setText(b);

            return view;
        }
    }

    static class ViewHolder {
        public TextView tvVideo;
    }

    public void setListViewHeightBasedOnChildren(ListView listView) {
    // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {
            // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            // 计算子项View 的宽高
            listItem.measure(0, 0);
            // 统计所有子项的总高度
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() *
                (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }
}
