package com.hack.apps.starter.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;

public class Permissions {


    private static String[] permissions = new String[]{
            Manifest.permission.INTERNET,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA

    };

    private static String[] locationkPermissions = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
    };

    public static boolean isGranted(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {

            ArrayList<String> tmpPermissions = new ArrayList<>();
            for (String permission : permissions) {
                if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED)
                    tmpPermissions.add(permission);
            }
            if (tmpPermissions.size() > 0) {
                ActivityCompat.requestPermissions(activity, tmpPermissions.toArray(new String[0]), 1);
                return false;
            }
            return false;
        } else return true;
    }

    private static boolean checkForGrant(Activity activity, String[] grantStr) {
        if (Build.VERSION.SDK_INT >= 23) {
            ArrayList<String> tmpPermissions = new ArrayList<>();
            for (String permission : grantStr) {
                if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED)
                    tmpPermissions.add(permission);
            }
            if (tmpPermissions.size() > 0) {
                ActivityCompat.requestPermissions(activity, tmpPermissions.toArray(new String[0]), Constants.PERMISSION_REQUEST);
                return false;
            }
            return true;
        } else return true;
    }

    public static boolean isLocationGranted(Activity activity) {
        return checkForGrant(activity, locationkPermissions);
    }



}
