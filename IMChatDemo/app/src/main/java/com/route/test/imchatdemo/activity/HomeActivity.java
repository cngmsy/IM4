package com.route.test.imchatdemo.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.route.test.imchatdemo.R;
import com.route.test.imchatdemo.base.BaseActivity;
import com.route.test.imchatdemo.base.BaseFragment;
import com.route.test.imchatdemo.base.FragmentBuilder;
import com.route.test.imchatdemo.base.MyApp;
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

    private long mExitTime;
    private FragmentManager fragmentManager=getSupportFragmentManager();
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




    /**
     * 自定义回退栈管理；
     * 获取栈顶的fragment的名字，判断名字是否和主页的名字是否一样，
     * 如果一样就退出应用，如果不是就回退上一个fragment；
     *
     * onBackPressed()与onKeyDown
     */
    @Override
    public void onBackPressed() {
        String simpleName = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        if ("ChatFragment".equals(simpleName) ||
                "FriendsFragment".equals(simpleName) ||
                "SetFragment".equals(simpleName)
                ) {
            finish();
        } else {
            if (fragmentManager.getBackStackEntryCount() > 1) {
                fragmentManager.popBackStackImmediate();//
                String name = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
                MyApp.mBaseLastFragment= (BaseFragment) fragmentManager.findFragmentByTag(name);
            }
        }
    }

    /**
     * 双击退出
     *
     * @param keyCode
     * @param event
     * @return
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        String name = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        if ("ChatFragment".equals(name) ||
                "FriendsFragment".equals(name) ||
                "SetFragment".equals(name)
                ){
            if (keyCode == KeyEvent.KEYCODE_BACK) {//back键被按下了
                if ((System.currentTimeMillis() - mExitTime) >2000) {//第二次点击判断是否在两秒内完成，是的话Finish掉（退出）
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();
                } else {
                    finish();
                    System.exit(0);
                }
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
