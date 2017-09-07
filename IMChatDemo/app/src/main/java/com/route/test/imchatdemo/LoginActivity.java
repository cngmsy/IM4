package com.route.test.imchatdemo;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.route.test.imchatdemo.base.BaseActivity;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    private boolean progressShow;
    private boolean autoLogin = false;
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void initData() {

    }

    @Override
    protected void initId() {
        usernameEditText = (EditText) findViewById(R.id.username);
        passwordEditText = (EditText) findViewById(R.id.password);

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    public void login(View view) {

    }
    public void register(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }

}
