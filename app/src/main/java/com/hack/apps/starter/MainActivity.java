package com.hack.apps.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.hack.apps.starter.auth.facebook.FacebookAuth;
import com.hack.apps.starter.auth.facebook.FacebookPostActivity;
import com.hack.apps.starter.auth.vk.VkAuth;
import com.hack.apps.starter.dashboard.DashboardFragmment;
import com.hack.apps.starter.db.CommonSettingsDB;
import com.hack.apps.starter.db.UserDB;
import com.hack.apps.starter.onboarding.OnboardingActivity;
import com.hack.apps.starter.search.SearchFragmment;
import com.hack.apps.starter.util.FragmentUtil;
import com.hack.apps.starter.util.Permissions;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.hack.apps.starter.db.DB.initDB;

public class MainActivity extends AppCompatActivity {
    public static String TAG = "MainActivity";

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

    @OnClick(R.id.facebookActivity)
    public void facebookClick(View view) {
        startActivity(new Intent(MainActivity.this, FacebookAuth.class));
    }

    @OnClick(R.id.vkLogin)
    public void vkLogin(View view) {
        VkAuth.login(MainActivity.this);
    }

    @OnClick(R.id.facebookPost)
    public void facebookPostClick(View view) {
        startActivity(new Intent(MainActivity.this, FacebookPostActivity.class));
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_dashboard:
                FragmentUtil.replaceFragment(MainActivity.this, DashboardFragmment.class, null, false);
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

        initMap();

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    //    Initialize Map to download play services
    public void initMap() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MapsInitializer.initialize(getApplicationContext());    //init client version
                    MapView mv = new MapView(getApplicationContext());        //init package version
                    mv.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            Log.e(TAG, "onMapReady");
                        }
                    });
                    mv.onCreate(null);
                    mv.onPause();
                    mv.onDestroy();
                } catch (Exception ignored) {

                }
            }
        }).start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {

                Log.e("SUCCESS", "LOGIN");

            }

            @Override
            public void onError(VKError error) {
                Log.e("FAILED", "LOGIN");
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
