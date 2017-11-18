package com.hack.apps.starter.util;

import android.os.Bundle;

import static com.hack.apps.starter.util.Constants.KEY_ID;
import static com.hack.apps.starter.util.Constants.KEY_IMAGE;
import static com.hack.apps.starter.util.Constants.KEY_NAME;
import static com.hack.apps.starter.util.Constants.KEY_RATING;

public class BundleUtil {
    public static Bundle getBundle(int id,String imageUri, String name, float rating) {
        Bundle profileBundle = new Bundle();
        profileBundle.putInt(KEY_ID, id);
        profileBundle.putString(KEY_NAME, name);
        profileBundle.putFloat(KEY_RATING, rating);
        profileBundle.putString(KEY_IMAGE, imageUri);
        return profileBundle;
    }
}
