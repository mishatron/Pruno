package com.hack.apps.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.hack.apps.starter.auth.LoginActivity;
import com.hack.apps.starter.db.CommonSettingsDB;
import com.hack.apps.starter.db.UserDB;
import com.hack.apps.starter.place.PlaceDetailsFragment;
import com.hack.apps.starter.settings.CommonSettings;
import com.hack.apps.starter.util.FragmentUtil;
import com.hack.apps.starter.util.Permissions;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.hack.apps.starter.db.DB.initDB;

public class MainActivity extends AppCompatActivity {


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

                return true;
            case R.id.navigation_search:
                FragmentUtil.replaceFragment(MainActivity.this, PlaceDetailsFragment.class, null, false);

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
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.exit) {

            CommonSettings commonSettings = CommonSettingsDB.get();
            commonSettings.setUserLoggined(false);
            commonSettings.setUserId(-1L);
            CommonSettingsDB.save(commonSettings);

            openLogin();
            finish();

            return false;
        }

        return super.onOptionsItemSelected(item);
    }

}
