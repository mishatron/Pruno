package com.hack.apps.starter.retrofit.query;

import com.hack.apps.starter.place.entity.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface CommentQuery {

    @GET("/placelist/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") Integer placeId);


}
