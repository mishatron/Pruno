package com.hack.apps.starter.retrofit.query;

import com.hack.apps.starter.model.PlaceResultModel;
import com.hack.apps.starter.place.entity.Place;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


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

    @GET("/placelist/{id}")
    Call<Place> getPlaceDetails(@Path("id") Integer placeId);
}
