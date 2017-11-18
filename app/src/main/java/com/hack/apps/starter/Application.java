package com.hack.apps.starter;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Application extends MultiDexApplication {

    @Override
    public void onTerminate() {
        super.onTerminate();
        Toast.makeText(this, "Something was wrong. Try again", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);

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