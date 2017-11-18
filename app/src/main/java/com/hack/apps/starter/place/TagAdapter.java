package com.hack.apps.starter.place;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hack.apps.starter.R;
import com.wefika.flowlayout.FlowLayout;

import java.util.List;


public class TagAdapter {


    TagAdapter(FlowLayout flowLayout, Context context, List<String> tags) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        for (String tag : tags) {

            View tagView = layoutInflater.inflate(R.layout.tag_view, null);
            tagView.setLayoutParams(new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT, FlowLayout.LayoutParams.WRAP_CONTENT));


            TextView tagTitle = tagView.findViewById(R.id.tag_title);

            tagTitle.setText(tag);

            flowLayout.addView(tagView);

        }


    }


}
