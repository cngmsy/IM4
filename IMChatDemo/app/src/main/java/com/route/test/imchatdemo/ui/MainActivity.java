package com.route.test.imchatdemo.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;

import com.route.test.imchatdemo.R;
import com.route.test.imchatdemo.base.BaseActivity;

public class MainActivity extends BaseActivity {


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                    break;
            }
        }
    };


    @Override
    protected void initData() {


    }

    @Override
    protected void initId() {
        handler.sendEmptyMessageDelayed(1,2000);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

}
