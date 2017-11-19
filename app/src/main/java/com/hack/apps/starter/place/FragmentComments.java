package com.hack.apps.starter.place;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import com.hack.apps.starter.R;
import com.hack.apps.starter.db.UserDB;
import com.hack.apps.starter.model.CommentPostModel;
import com.hack.apps.starter.place.entity.Comment;
import com.hack.apps.starter.retrofit.RetrofitUtil;
import com.hack.apps.starter.util.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hack.apps.starter.db.DB.initDB;


public class FragmentComments extends Fragment {

    private final static String TAG = FragmentComments.class.getCanonicalName();

    private Call commentsCall;


    CommentAdapter adapter;

    List<Comment> mList;

    ListView commentsListView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDB(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comments, container, false);

        mList = new ArrayList<>();

        commentsListView = view.findViewById(R.id.commentsListView);

        adapter = new CommentAdapter(getActivity(), mList);
        commentsListView.setAdapter(adapter);


        getComments(getArguments().getInt(Constants.KEY_ID));

        final FloatingActionButton makeRate = view.findViewById(R.id.rate_place);

        makeRate.setOnClickListener(v -> {

            showRateDialog();

        });

        return view;
    }


    private void showRateDialog() {


        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        alertDialog.setTitle("Оцініть місце");
        LayoutInflater factory = LayoutInflater.from(getContext());
        View dialogView = factory.inflate(R.layout.dialog_rate_place, null);


        MaterialRatingBar comfortRate = dialogView.findViewById(R.id.comfortRate);
        MaterialRatingBar serviceRate = dialogView.findViewById(R.id.serviceRate);
        MaterialRatingBar locationRate = dialogView.findViewById(R.id.locationRate);

        EditText message = dialogView.findViewById(R.id.message);


        alertDialog.setView(dialogView);

        //

        alertDialog.setPositiveButton("Оцінити", (dialog, id) -> {

            Comment comment = new Comment();
            comment.setMessage(message.getText().toString());
            comment.setUsername(UserDB.get().getUsername());
            comment.setComfortRate(comfortRate.getRating());
            comment.setServiceRate(serviceRate.getRating());
            comment.setLocationRate(locationRate.getRating());


            addComment(getArguments().getInt(Constants.KEY_ID), comment);

        });

        alertDialog.setNegativeButton("Відміна", (dialog, id) -> dialog.dismiss());

        alertDialog.show();


    }

    private void updateView(List<Comment> comments) {

        mList.clear();
        mList.addAll(comments);
        adapter.notifyDataSetChanged();

    }

    private void addComment(Integer placeId, Comment comment) {
        commentsCall = RetrofitUtil.getCommentQuery().postComment(placeId, new CommentPostModel(
                comment.getUsername(),
                comment.getMessage(),
                comment.getComfortRate(),
                comment.getServiceRate(),
                comment.getLocationRate()));

        commentsCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i(TAG, "makeLikeRequest successful");
                        ResponseBody res = response.body();

                        getComments(placeId);


                    }
                } else {
                    Log.e(TAG, "GetErrCode" + String.valueOf(response.code()));
                    try {
                        Log.e(TAG, "GetErrBody" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(TAG, "Unable to submit get." + t.toString());
                Log.e(TAG, "Unable to submit call." + call.request().body());
            }
        });
    }


    private void getComments(Integer placeId) {
        commentsCall = RetrofitUtil.getCommentQuery().getComments(placeId);
        commentsCall.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i(TAG, "makeLikeRequest successful");
                        List<Comment> comments = response.body();

                        updateView(comments);

                    }
                } else {
                    Log.e(TAG, "GetErrCode" + String.valueOf(response.code()));
                    try {
                        Log.e(TAG, "GetErrBody" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(TAG, "Unable to submit get." + t.toString());
                Log.e(TAG, "Unable to submit call." + call.request().body());
            }
        });
    }


}
