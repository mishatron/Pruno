package com.hack.apps.starter.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hack.apps.starter.R;
import com.hack.apps.starter.adapter.PlaceAdapter;
import com.hack.apps.starter.model.PlaceModel;
import com.hack.apps.starter.model.PlaceResultModel;
import com.hack.apps.starter.place.PlaceInfoFragment;
import com.hack.apps.starter.retrofit.RetrofitUtil;
import com.hack.apps.starter.util.BundleUtil;
import com.hack.apps.starter.util.Constants;
import com.hack.apps.starter.util.FragmentUtil;
import com.hack.apps.starter.util.RatingUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragmment extends Fragment {
    public static String TAG = "DashboardFragmment";
    private Call placeCall;

    @BindView(R.id.place_list_view)
    ListView placeListView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);

        makePlaceRequest();

        return view;
    }

    @OnItemClick(R.id.place_list_view)
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i(TAG, "item clicked");
        PlaceModel model = (PlaceModel) adapterView.getItemAtPosition(i);
        int id = model.getPlace_id();
        String name = model.getTitle();
        String photo = model.getIcon();
        float rating = RatingUtil.calculateRate(model.getLocationRate(), model.getServiceRate(), model.getComfortRate());
        FragmentUtil.replaceFragment(getActivity(), PlaceInfoFragment.class, BundleUtil.getBundle(id), true);
//        openMap();
    }

    void openMap() {
        Intent intent = new Intent(getActivity(), MapFragment.class);
        intent.putExtra(Constants.KEY_LAT, 49.266140);
        intent.putExtra(Constants.KEY_LNG, 29.753952);
        intent.putExtra(Constants.KEY_TITLE, "Title");
        startActivity(intent);
    }


    private void makePlaceRequest() {
        placeCall = RetrofitUtil.getPlaceQuery().getPlaceList();
        placeCall.enqueue(new Callback<PlaceResultModel>() {
            @Override
            public void onResponse(Call<PlaceResultModel> call, Response<PlaceResultModel> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        Log.i(TAG, "makeLikeRequest successful");
                        List<PlaceModel> model = response.body().getResults();
                        Collections.sort(model, new Comparator<PlaceModel>() {
                            @Override
                            public int compare(PlaceModel o1, PlaceModel o2) {
                                return (int)(o1.getMidRate()-o2.getMidRate());
                            }
                        });

                        if (model != null) {
                            placeListView.setAdapter(new PlaceAdapter(getActivity(), model));
                        }
                        Log.e(TAG, "get place submitted." + response.body().toString());
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
