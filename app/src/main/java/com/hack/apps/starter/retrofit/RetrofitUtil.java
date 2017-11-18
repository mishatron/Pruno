package com.hack.apps.starter.retrofit;

import com.hack.apps.starter.retrofit.query.PlaceQuery;

import static com.hack.apps.starter.util.Constants.BASE_URL;


public class RetrofitUtil {

    public static PlaceQuery getPlaceQuery() {
        return RetrofitClient.getClient(BASE_URL).create(PlaceQuery.class);
    }

    private RetrofitUtil() {
    }
}
