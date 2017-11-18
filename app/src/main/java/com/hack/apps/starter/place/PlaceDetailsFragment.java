package com.hack.apps.starter.place;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.hack.apps.starter.R;
import com.hack.apps.starter.filter.FilterActivity;
import com.hack.apps.starter.place.entity.Place;
import com.hack.apps.starter.retrofit.RetrofitUtil;
import com.hack.apps.starter.util.Constants;
import com.wefika.flowlayout.FlowLayout;

import java.io.IOException;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlaceDetailsFragment extends Fragment {

    private static final String TAG = PlaceDetailsFragment.class.getCanonicalName();

    private Call detailsCall;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.description)
    TextView description;
    @BindView(R.id.tags)
    FlowLayout flowLayout;

    @BindView(R.id.comfortRate)
    MaterialRatingBar comfortRate;
    @BindView(R.id.serviceRate)
    MaterialRatingBar serviceRate;
    @BindView(R.id.locationRate)
    MaterialRatingBar locationRate;

    @BindView(R.id.gridview)
    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_place_details, container, false);

        ButterKnife.bind(this, view);

        comfortRate.setEnabled(false);
        serviceRate.setEnabled(false);
        locationRate.setEnabled(false);


        Integer placeId = getArguments().getInt(Constants.KEY_ID);

        getPlaceDetails(placeId);

        return view;
    }

    void openDialogActivity() {

        startActivity(new Intent(getActivity(), FilterActivity.class));
    }

    private void updateView(Place place) {

        ImageAdapter imagesAdapter = new ImageAdapter(getActivity(), Arrays.asList(place.getPhotos()));
        gridView.setAdapter(imagesAdapter);

        new TagAdapter(flowLayout, getActivity(), Arrays.asList(place.getTags()));

        title.setText(place.getTitle());
        description.setText(place.getDescription());

        comfortRate.setRating(place.getComfortRate());
        serviceRate.setRating(place.getServiceRate());
        locationRate.setRating(place.getLocationRate());

    }


    private void getPlaceDetails(Integer placeId) {
        detailsCall = RetrofitUtil.getPlaceQuery().getPlaceDetails(placeId);
        detailsCall.enqueue(new Callback<Place>() {
            @Override
            public void onResponse(Call<Place> call, Response<Place> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i(TAG, "makeLikeRequest successful");
                        Place model = response.body();

                        updateView(model);

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
