package com.hack.apps.starter.retrofit.query;

import com.hack.apps.starter.model.CommentPostModel;
import com.hack.apps.starter.model.PlaceResultModel;
import com.hack.apps.starter.place.entity.Place;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface PlaceQuery {
    @GET("/placelist")
    Call<PlaceResultModel> getPlaceList();

    @GET("/placelist/{id}")
    Call<Place> getPlaceDetails(@Path("id") Integer placeId);

    @POST("/placelist/{place_id}/addcomment")
    Call<ResponseBody> postComment(@Path("place_id") int id, @Body CommentPostModel body);
}
