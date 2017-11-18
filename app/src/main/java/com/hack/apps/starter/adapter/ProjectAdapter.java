package com.hack.apps.starter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hack.apps.starter.R;
import com.hack.apps.starter.model.ProjectModel;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProjectAdapter extends BaseAdapter {
    private Context context;
    private List<ProjectModel> list;

    public ProjectAdapter(Context context, List<ProjectModel> model) {
        this.context = context;
        this.list = model;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.item_fragment_dashboard, viewGroup, false);

        ((TextView) itemView.findViewById(R.id.project_name)).setText(list.get(i).getName());
        ((TextView) itemView.findViewById(R.id.project_description)).setText(list.get(i).getDescription());

        CircleImageView img = (CircleImageView) itemView.findViewById(R.id.project_image);

        if (list.get(i).getImageUri() != null) {
            Picasso.with(context)
                    .load(list.get(i).getImageUri())
                    .into(img);
        }
        else {
            img.setImageResource(R.drawable.circle);
        }
        return itemView;
    }

}
