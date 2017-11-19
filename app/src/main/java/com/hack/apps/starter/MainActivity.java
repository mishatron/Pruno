package com.hack.apps.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.hack.apps.starter.auth.LoginActivity;
import com.hack.apps.starter.dashboard.BookmarksFragmment;
import com.hack.apps.starter.dashboard.DashboardFragmment;
import com.hack.apps.starter.db.CommonSettingsDB;
import com.hack.apps.starter.db.UserDB;
import com.hack.apps.starter.filter.entity.Filter;
import com.hack.apps.starter.settings.SettingsFragmment;
import com.hack.apps.starter.util.FragmentUtil;
import com.hack.apps.starter.util.Permissions;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.hack.apps.starter.db.DB.initDB;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "MainActivity";

    public static Filter filter = null;

    @BindView(R.id.navigation)
    BottomNavigationView navigation;


    @Override
    protected void onResume() {
        super.onResume();

        initDB(MainActivity.this);

        if (!CommonSettingsDB.get().isUserLoggined())
            openLogin();

        UserDB.findById(CommonSettingsDB.get().getUserId());

        Log.e("user id", CommonSettingsDB.get().getUserId() + "");

    }

    private void openLogin() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
        finish();
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_dashboard:
                FragmentUtil.replaceFragment(MainActivity.this, DashboardFragmment.class, null, false);
                return true;
            case R.id.navigation_bookmarks:
                FragmentUtil.replaceFragment(MainActivity.this, BookmarksFragmment.class, null, false);
                return true;
            case R.id.navigation_settings:
                FragmentUtil.replaceFragment(MainActivity.this, SettingsFragmment.class, null, false);
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


        FragmentUtil.replaceFragment(MainActivity.this, DashboardFragmment.class, null, false);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

//        if (requestCode == 1) {

        Log.e("REQUEST CODE", "Apply filter " + resultCode);

//        }


    }

}
