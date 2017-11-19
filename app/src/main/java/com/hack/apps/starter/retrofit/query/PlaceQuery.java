package com.hack.apps.starter.retrofit.query;

import com.hack.apps.starter.filter.entity.Filter;
import com.hack.apps.starter.model.PlaceResultModel;
import com.hack.apps.starter.place.entity.Place;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface PlaceQuery {
    @GET("/placelist")
    Call<PlaceResultModel> getPlaceList();

    @POST("/placelist/filter")
    Call<PlaceResultModel> getPlaceListByFilter(@Body Filter filter);

    @GET("/placelist/{id}")
    Call<Place> getPlaceDetails(@Path("id") Integer placeId);

}
