package com.hack.apps.starter.place;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hack.apps.starter.R;
import com.hack.apps.starter.util.Tag;
import com.wefika.flowlayout.FlowLayout;

import java.util.List;


public class TagAdapter {


    public TagAdapter(FlowLayout flowLayout, Context context, List<String> tags) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        for (String tag : tags) {

            View tagView = layoutInflater.inflate(R.layout.tag_view, null);
            tagView.setLayoutParams(new FlowLayout.LayoutParams(FlowLayout.LayoutParams.WRAP_CONTENT, FlowLayout.LayoutParams.WRAP_CONTENT));


            CardView tagCardView = tagView.findViewById(R.id.tag_card_view);
            TextView tagTitle = tagView.findViewById(R.id.tag_title);
            ImageView icon = tagView.findViewById(R.id.icon);

            Tag t = Tag.WIFI;

            if (tag.equals(Tag.REST.getTitle()))
                t = Tag.REST;
            else if (tag.equals(Tag.WORK.getTitle()))
                t = Tag.WORK;
            else if (tag.equals(Tag.FOOD.getTitle()))
                t = Tag.FOOD;

            icon.setImageResource(t.getImage());

            tagCardView.setCardBackgroundColor(t.getColor());

            tagTitle.setText(tag);

            flowLayout.addView(tagView);

        }


    }


}
