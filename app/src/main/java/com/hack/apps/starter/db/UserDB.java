package com.hack.apps.starter.db;

import android.util.Log;

import com.hack.apps.starter.profile.entity.User;

public class UserDB {

    private static Long userId;
    private static String TAG = "UserDB";

    public static User get() {
        return User.findById(User.class, userId);
    }

    //return user id
    public static Long save(User user) {

        Long id = User.save(user);
        Log.e("saved user", user + "with id " + id);
        userId = id;
        return id;
    }

    public static User findById(Long id) {
        User user = User.findById(User.class, id);
        if (user == null) {
            Log.e(TAG, "Unable to find user with id [" + id + "]");
            return null;
        }
        userId = user.getId();
        return user;
    }

}
