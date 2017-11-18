package com.hack.apps.starter.place;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hack.apps.starter.R;
import com.stfalcon.frescoimageviewer.ImageViewer;

import java.util.List;

public class ImageAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<String> images;


    public ImageAdapter(Context context, List<String> images) {
        this.mContext = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final String imageUrl = images.get(position);

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.image_view, null);
        }

        final SimpleDraweeView imageView = convertView.findViewById(R.id.image);

        imageView.setImageURI(imageUrl);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPicker(position);
            }
        });

        return convertView;
    }

    private void showPicker(int startPosition) {
        new ImageViewer.Builder<>(mContext, images)
                .setStartPosition(startPosition)
                .show();
    }


}