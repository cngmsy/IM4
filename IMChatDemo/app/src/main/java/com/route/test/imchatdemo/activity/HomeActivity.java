package com.route.test.imchatdemo.activity;

import android.support.annotation.IdRes;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

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
    private ImageView em_add;

    @Override
    protected void initData() {
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                if (rbChat.getId() == i) {
                    FragmentBuilder.getFragmentBuilder().containerId(R.id.MainFrameLayout).satrt(ChatFragment.class).build();
                    tvContent.setText("会话");
                    em_add.setVisibility(View.GONE);
                }
                if (rbFriends.getId() == i) {
                    FragmentBuilder.getFragmentBuilder().containerId(R.id.MainFrameLayout).satrt(FriendsFragment.class).build();
                    tvContent.setText("通讯录");
                    em_add.setVisibility(View.VISIBLE);
                }
                if (rbSet.getId() == i) {
                    FragmentBuilder.getFragmentBuilder().containerId(R.id.MainFrameLayout).satrt(SetFragment.class).build();
                    tvContent.setText("设置");
                    em_add.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void initId() {
        tvContent = findViewById(R.id.tv_content);
        MainFrameLayout = findViewById(R.id.MainFrameLayout);
        rbChat = findViewById(R.id.rb_chat);
        rbFriends = findViewById(R.id.rb_friends);
        rbSet = findViewById(R.id.rb_set);
        rg = findViewById(R.id.rg);
        em_add = findViewById(R.id.em_add);
        FragmentBuilder.getFragmentBuilder().containerId(R.id.MainFrameLayout).satrt(ChatFragment.class).build();

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

}
