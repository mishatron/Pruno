package com.hack.apps.starter.place;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hack.apps.starter.R;
import com.hack.apps.starter.place.entity.Comment;

import java.util.List;

class CommentAdapter extends BaseAdapter {

    private Context context;
    private List<Comment> comments;


    CommentAdapter(Context context, List<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    @Override
    public int getCount() {
        return comments.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.item_comment, parent, false);


        TextView username = itemView.findViewById(R.id.username);
        TextView date = itemView.findViewById(R.id.date);
        TextView message = itemView.findViewById(R.id.message);

        Comment comment = comments.get(position);

        username.setText(comment.getUsername());
        date.setText(comment.getDate());
        message.setText(comment.getMessage());

        return itemView;
    }

}

