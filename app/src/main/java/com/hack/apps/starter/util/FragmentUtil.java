package com.hack.apps.starter.util;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;


public class FragmentUtil {

    public static void replaceFragment(FragmentActivity context, Class<? extends Fragment> fragmentClass, Bundle bundle, boolean toStack) {

        int content = 0;

        Fragment fragment = null;
        try {
            fragment = fragmentClass.newInstance();
            fragment.setArguments(bundle);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        FragmentTransaction transaction = context.getSupportFragmentManager()
                .beginTransaction()
                .replace(content, fragment);
        if (toStack) {
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }

}
