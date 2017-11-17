package com.hack.apps.starter.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class OnboardingPreference {
    private String TAG = "OnboardingPreference";
    private String KEY_FIRST_USE="first_use";
    private SharedPreferences preferences;

    public OnboardingPreference(Context context) {
        preferences = context.getSharedPreferences("onboardingPreference", Context.MODE_PRIVATE);
    }

    public void setFirstUse(boolean firstUse) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(KEY_FIRST_USE, firstUse).apply();
        Log.e(TAG, "firstUse set " + firstUse);
    }

    public Boolean getFirstUse() {
        return preferences.getBoolean(KEY_FIRST_USE, true);
    }

}
