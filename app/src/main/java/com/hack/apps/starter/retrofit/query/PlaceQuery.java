package com.hack.apps.starter.retrofit.query;

import com.hack.apps.starter.model.PlaceResultModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface PlaceQuery {
//    /**
//     * Post
//     **/
//    @POST("/endpoint")
//    Call<ResponseBody> postComment(@Body CommentPostModel commentModel);

    /**
     * Get comment
     **/
    @GET("/placelist")
    Call<PlaceResultModel> getPlaceList();


}
