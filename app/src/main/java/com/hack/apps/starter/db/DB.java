package com.hack.apps.starter.db;

import android.content.Context;

import com.orm.SugarContext;

public class DB {


    private static String TAG = "DB";

    public static void initDB(Context context) {
        SugarContext.init(context);
    }

}
