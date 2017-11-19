package com.hack.apps.starter.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hack.apps.starter.R;
import com.hack.apps.starter.auth.LoginActivity;
import com.hack.apps.starter.db.CommonSettingsDB;
import com.hack.apps.starter.place.entity.Place;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.hack.apps.starter.db.DB.initDB;

public class SettingsFragmment extends Fragment {
    public static String TAG = "DashboardFragmment";


    @BindView(R.id.exit)
    CardView exit;

    @BindView(R.id.clearBookmarks)
    CardView clearBookmarks;


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDB(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        ButterKnife.bind(this, view);

        toolbar.setTitle("Налаштування");


        exit.setOnClickListener(v -> {

            CommonSettings commonSettings = CommonSettingsDB.get();
            commonSettings.setUserLoggined(false);
            CommonSettingsDB.save(commonSettings);

            startActivity(new Intent(getActivity(), LoginActivity.class));

        });

        clearBookmarks.setOnClickListener(v -> {

            Place.deleteAll(Place.class);

        });

        return view;
    }


}
