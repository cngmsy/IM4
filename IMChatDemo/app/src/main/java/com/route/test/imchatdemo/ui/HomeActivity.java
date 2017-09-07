package com.route.test.imchatdemo.ui;

import android.support.annotation.IdRes;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.route.test.imchatdemo.R;
import com.route.test.imchatdemo.base.BaseActivity;
import com.route.test.imchatdemo.base.FragmentBuilder;
import com.route.test.imchatdemo.fragment.ChatFragment;
import com.route.test.imchatdemo.fragment.FriendsFragment;
import com.route.test.imchatdemo.fragment.SetFragment;

public class HomeActivity extends BaseActivity {

    TextView tvContent;
    FrameLayout MainFrameLayout;
    RadioButton rbChat;
    RadioButton rbFriends;
    RadioButton rbSet;
    RadioGroup rg;


    @Override
    protected void initData() {


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if(rbChat.getId()==i){
                    FragmentBuilder.getFragmentBuilder().containerId(R.id.MainFrameLayout).satrt(ChatFragment.class).build();
                    tvContent.setText("会话");
                }
                if(rbFriends.getId()==i){
                    FragmentBuilder.getFragmentBuilder().containerId(R.id.MainFrameLayout).satrt(FriendsFragment.class).build();
                    tvContent.setText("通讯录");
                }
                if(rbSet.getId()==i){
                    FragmentBuilder.getFragmentBuilder().containerId(R.id.MainFrameLayout).satrt(SetFragment.class).build();
                    tvContent.setText("设置");
                }
            }
        });
    }

    @Override
    protected void initId() {
        tvContent = findViewById(R.id.tv_content);
        MainFrameLayout= findViewById(R.id.MainFrameLayout);
        rbChat= findViewById(R.id.rb_chat);
        rbFriends=findViewById(R.id.rb_friends);
        rbSet=findViewById(R.id.rb_set);
        rg=findViewById(R.id.rg);
        FragmentBuilder.getFragmentBuilder().containerId(R.id.MainFrameLayout).satrt(ChatFragment.class).build();

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }
        private long firstTime = 0;
            @Override
            public boolean onKeyUp(int keyCode, KeyEvent event) {
                switch (keyCode) {
                    case KeyEvent.KEYCODE_BACK:
                        long secondTime = System.currentTimeMillis();
                        if (secondTime - firstTime > 2000) {
                            Toast.makeText(HomeActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                            firstTime = secondTime;
                            return true;
                        } else {
                            System.exit(0);
                        }
                        break;
                }
                return super.onKeyUp(keyCode, event);
            }
}
