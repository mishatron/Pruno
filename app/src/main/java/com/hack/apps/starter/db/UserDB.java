package com.hack.apps.starter.db;

import android.util.Log;

import com.hack.apps.starter.profile.entity.User;

import java.util.List;

import static com.orm.SugarRecord.find;

public class UserDB {

    private static Long userId = 1L;
    private static String TAG = "UserDB";

    public static User get() {
        return User.findById(User.class, userId);
    }

    //return user id
    public static Long save(User user) {

        Long id = User.save(user);
        Log.e("saved user", user + "with id " + id);
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

    public static User findByUsername(String username) {
        List<User> list = find(User.class, "username=?", new String[]{username}, null, null, "1");
        if (list.isEmpty()) {
            Log.e(TAG, "Unable to find user with username [" + username + "]");
            return null;
        }
        User user = list.get(0);
        userId = user.getId();
        return user;
    }

}
