package com.hack.apps.starter.util;

import android.os.Bundle;

import static com.hack.apps.starter.util.Constants.KEY_DESCRIPTION;
import static com.hack.apps.starter.util.Constants.KEY_ID;
import static com.hack.apps.starter.util.Constants.KEY_IMAGE;
import static com.hack.apps.starter.util.Constants.KEY_NAME;

public class BundleUtil {
    public static Bundle getBundle(int id, String name, String description, String imageUri) {
        Bundle profileBundle = new Bundle();
        profileBundle.putInt(KEY_ID, id);
        profileBundle.putString(KEY_NAME, name);
        profileBundle.putString(KEY_DESCRIPTION, description);
        profileBundle.putString(KEY_IMAGE, imageUri);
        return profileBundle;
    }
}
