package com.hack.apps.starter.place;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.hack.apps.starter.R;
import com.hack.apps.starter.filter.FilterActivity;
import com.wefika.flowlayout.FlowLayout;

import java.util.Arrays;

public class PlaceDetailsFragment extends Fragment {

    private static final String TAG = PlaceDetailsFragment.class.getCanonicalName();


    private static final String[] images = {
            "https://pp.vk.me/c630619/v630619423/4637a/vAOodrqPzQM.jpg",
            "https://pp.vk.me/c630619/v630619423/46395/71QKIPW6BWM.jpg",
            "https://pp.vk.me/c630619/v630619423/46383/GOTf1IvHKoc.jpg",
            "https://pp.vk.me/c630619/v630619423/4638c/i1URx2fWj20.jpg",
            "https://pp.vk.me/c630619/v630619423/4639e/BPoHv4xEikA.jpg",
            "https://pp.vk.me/c630619/v630619423/463a7/9EjA0oqA_yQ.jpg",
            "https://pp.vk.me/c630619/v630619423/463b0/VLPAZQJ0kuI.jpg",
            "https://pp.vk.me/c630619/v630619423/463b9/O3-hk8kIvdY.jpg",
            "https://pp.vk.me/c630619/v630619423/463c2/WgtvE0FQwVY.jpg"
    };


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_place_details, container, false);

        toolbar = view.findViewById(R.id.toolbar);

        toolbar.setTitle("Categories");
        toolbar.inflateMenu(R.menu.categories_menu);

        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.filter) {

                openDialogActivity();

            }
            return false;
        });


        GridView gridView = view.findViewById(R.id.gridview);
        ImageAdapter imagesAdapter = new ImageAdapter(getActivity(), Arrays.asList(images));
        gridView.setAdapter(imagesAdapter);

        FlowLayout flowLayout = view.findViewById(R.id.tags);

        new TagAdapter(flowLayout, getActivity(), Arrays.asList("awrgq", "wwerg", "Wetew", "rewweq"));
        return view;
    }

    void openDialogActivity() {

        startActivity(new Intent(getActivity(), FilterActivity.class));
    }


}
