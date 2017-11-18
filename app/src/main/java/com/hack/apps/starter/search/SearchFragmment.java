package com.hack.apps.starter.search;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack.apps.starter.R;
import com.hack.apps.starter.db.UserDB;


public class SearchFragmment extends Fragment {

    private static final String TAG = SearchFragmment.class.getCanonicalName();

    public SearchFragmment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        toolbar = view.findViewById(R.id.toolbar);

        toolbar.setTitle("Categories");
        toolbar.inflateMenu(R.menu.categories_menu);

        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.filter) {


            }

            return false;
        });


        Log.e(TAG, UserDB.get() + "");


        return view;
    }
}
