package com.example.fiveknowacan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.fiveknowacan.R;

public class PlayVideoActivity extends Activity {

    private static final String KEY_INDEX = "CURRENT_POSITION";
    VideoView mVideoNet;
    Button mBtnRotating;
    int mCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_play_video);
        initView();
//        initLocalVideo();
        initNetVideo();
        initEvent();
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(KEY_INDEX, 0);
        }
    }

    private void initEvent() {
        mBtnRotating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PlayVideoActivity.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
            }
        });
    }

    private void initView() {
        mVideoNet = findViewById(R.id.video_net);
        mBtnRotating = findViewById(R.id.btn_rotating);
    }

/*
    //播放本地视频
    private void initLocalVideo() {
        //设置有进度条可以拖动快进
        MediaController localMediaController = new MediaController(this);
        mVideoLocal.setMediaController(localMediaController);
        String uri = ("android.resource://" + getPackageName() + "/" + R.raw.v1);
        mVideoLocal.setVideoURI(Uri.parse(uri));
        mVideoLocal.start();
    }
*/

    //播放网络视频
    private void initNetVideo() {
        //设置有进度条可以拖动快进
        MediaController localMediaController = new MediaController(this);
        mVideoNet.setMediaController(localMediaController);
        String url = "http://172.16.18.134:8080/zhbj/OqJAZ893T-mobile.mp4";
        mVideoNet.setVideoPath(url);
        mVideoNet.start();
    }


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
//        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mVideoNet.getCurrentPosition());
    }
}