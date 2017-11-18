package com.hack.apps.starter.db;

import com.hack.apps.starter.settings.CommonSettings;

public class CommonSettingsDB {

    private static String TAG = CommonSettingsDB.class.getCanonicalName();

    private static CommonSettings commonSettings;

    static {
        if (!isExist()) {
            commonSettings = new CommonSettings();
            commonSettings.setFirstUse(true);
            commonSettings.setUserLoggined(false);
            commonSettings.save();
        }
        commonSettings = CommonSettings.first(CommonSettings.class);
    }

    public static CommonSettings get() {
        return commonSettings;
    }

    public static void save(CommonSettings c) {
        commonSettings = c;
        commonSettings.save();
    }

    private static Boolean isExist() {
        return CommonSettings.first(CommonSettings.class) != null;
    }


}
