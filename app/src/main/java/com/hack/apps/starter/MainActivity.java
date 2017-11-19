package com.hack.apps.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hack.apps.starter.db.CommonSettingsDB;
import com.hack.apps.starter.db.UserDB;
import com.hack.apps.starter.onboarding.OnboardingActivity;
import com.hack.apps.starter.search.SearchFragmment;
import com.hack.apps.starter.util.FragmentUtil;
import com.hack.apps.starter.util.Permissions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hack.apps.starter.db.DB.initDB;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.facebookActivity)
    Button facebook;

    @BindView(R.id.facebookPost)
    Button facebookPost;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;


    @Override
    protected void onResume() {
        super.onResume();

        initDB(MainActivity.this);

        if (CommonSettingsDB.get().isFirstUse())
            openOnboarding();
    }

    private void openOnboarding() {
        Intent intent = new Intent(MainActivity.this, OnboardingActivity.class);
        startActivity(intent);
        finish();
    }




    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_dashboard:

                return true;
            case R.id.navigation_search:
                FragmentUtil.replaceFragment(MainActivity.this, SearchFragmment.class, null, false);

                return true;
            case R.id.navigation_bookmarks:
                return true;
            case R.id.navigation_profile:
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Permissions.isGranted(MainActivity.this);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDB(MainActivity.this);


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


    }

}
