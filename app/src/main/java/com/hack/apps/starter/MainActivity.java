package com.hack.apps.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.hack.apps.starter.auth.facebook.FacebookAuth;
import com.hack.apps.starter.auth.facebook.FacebookPostActivity;
import com.hack.apps.starter.profile.entity.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static User user;

    @BindView(R.id.facebookActivity)
    Button facebook;

    @BindView(R.id.facebookPost)
    Button facebookPost;

//    @BindView(R.id.vkActivity)
//    Button vk;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @OnClick(R.id.facebookActivity)
    public void facebookClick(View view) {
        startActivity(new Intent(MainActivity.this, FacebookAuth.class));
    }

    @OnClick(R.id.facebookPost)
    public void facebookPostClick(View view) {
        startActivity(new Intent(MainActivity.this, FacebookPostActivity.class));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                return true;
            case R.id.navigation_dashboard:
                return true;
            case R.id.navigation_notifications:
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        user = new User();
        user.setUserName("Igor");


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
