package com.hack.apps.starter.util;

import android.os.Bundle;

import static com.hack.apps.starter.util.Constants.KEY_ID;
import static com.hack.apps.starter.util.Constants.KEY_IMAGE;
import static com.hack.apps.starter.util.Constants.KEY_NAME;
import static com.hack.apps.starter.util.Constants.KEY_RATING;

public class BundleUtil {
    public static Bundle getBundle(int id) {
        Bundle profileBundle = new Bundle();
        profileBundle.putInt(KEY_ID, id);
        return profileBundle;
    }
}
