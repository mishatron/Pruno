package com.hack.apps.starter.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hack.apps.starter.R;
import com.hack.apps.starter.util.FragmentUtil;

import butterknife.BindView;
import butterknife.OnItemClick;

public class DashboardDetailFragmment extends Fragment {

    @BindView(R.id.place_list_view)
    ListView projectListView;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard_detail, container, false);

        return view;
    }

}
