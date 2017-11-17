package com.hack.apps.starter;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.hack.apps.starter.auth.LoginActivity;
import com.hack.apps.starter.db.CommonSettingsDB;
import com.hack.apps.starter.settings.CommonSettings;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKAccessTokenTracker;
import com.vk.sdk.VKSdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static com.hack.apps.starter.db.DB.initDB;

public class Application extends MultiDexApplication {
    VKAccessTokenTracker tokenTracker = new VKAccessTokenTracker() {
        @Override
        public void onVKAccessTokenChanged(VKAccessToken oldToken, VKAccessToken newToken) {
            if (newToken == null) {
                Intent intent = new Intent(Application.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        }
    };

    @Override
    public void onTerminate() {
        super.onTerminate();
        Toast.makeText(this, "Something was wrong. Try again", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        tokenTracker.startTracking();
        VKSdk.initialize(this);
        FacebookSdk.sdkInitialize(this);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        HashKey();
    }

    public void HashKey() {
        try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.hack.apps.starter",
                    PackageManager.GET_SIGNATURES);
            for (android.content.pm.Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));

            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}