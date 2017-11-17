package com.hack.apps.starter.auth.vk;

import android.app.Activity;
import android.util.Log;

import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;

public class VkAuth {

    public static void login(Activity activity) {
        VKSdk.login(activity, VKScope.WALL, VKScope.EMAIL, VKScope.GROUPS, VKScope.PHOTOS);
    }

    public static void logout() {
        VKSdk.logout();
    }

    public String getAccessToken() {
        return VKAccessToken.currentToken().accessToken;
    }

    public static Integer getUserId() {
        final VKAccessToken vkAccessToken = VKAccessToken.currentToken();
        String userId = vkAccessToken.userId;
        Log.e("USER ID", userId);
        return Integer.valueOf(userId);
    }

}
