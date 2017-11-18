package com.hack.apps.starter.place;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.hack.apps.starter.R;
import com.hack.apps.starter.place.entity.Comment;

import java.util.ArrayList;


public class FragmentComments extends Fragment {


    CommentAdapter adapter;

    ArrayList<Comment> mList;

    ListView commentsListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, container, false);

        mList = new ArrayList<>();

        commentsListView = view.findViewById(R.id.commentsListView);

        adapter = new CommentAdapter(getActivity(), mList);
        commentsListView.setAdapter(adapter);


        final FloatingActionButton makeRate = view.findViewById(R.id.rate_place);

        makeRate.setOnClickListener(v -> {


        });

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


}
