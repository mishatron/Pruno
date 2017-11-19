package com.hack.apps.starter.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hack.apps.starter.MainActivity;
import com.hack.apps.starter.R;
import com.hack.apps.starter.adapter.PlaceAdapter;
import com.hack.apps.starter.filter.FilterActivity;
import com.hack.apps.starter.filter.entity.Filter;
import com.hack.apps.starter.model.PlaceModel;
import com.hack.apps.starter.model.PlaceResultModel;
import com.hack.apps.starter.place.PlaceInfoFragment;
import com.hack.apps.starter.place.entity.Place;
import com.hack.apps.starter.retrofit.RetrofitUtil;
import com.hack.apps.starter.util.BundleUtil;
import com.hack.apps.starter.util.Constants;
import com.hack.apps.starter.util.FragmentUtil;
import com.hack.apps.starter.util.RatingUtil;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.hack.apps.starter.db.DB.initDB;

public class BookmarksFragmment extends Fragment {
    public static String TAG = "DashboardFragmment";
    private Call placeCall;

    private Integer minPrice = 99999999, maxPrice = 0;


    @BindView(R.id.place_list_view)
    ListView placeListView;


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public void onResume() {
        super.onResume();



    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initDB(getActivity());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);

        toolbar.setTitle("Обрані");

        List<Place> places = Place.listAll(Place.class);

        Log.e("Bookmarks size", places.size()+"");

        if (places != null) {
            placeListView.setAdapter(new BookmarkAdapter(getActivity(), places));
        }


        return view;
    }

    private void openFilterActivity() {

        Intent intent = new Intent(getActivity(), FilterActivity.class);
        intent.putExtra(Constants.MIN_PRICE, minPrice);
        intent.putExtra(Constants.MAX_PRICE, maxPrice);
        startActivityForResult(intent, 1);

    }

    @OnItemClick(R.id.place_list_view)
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i(TAG, "item clicked");
        Place model = (Place) adapterView.getItemAtPosition(i);
        Long id = model.getId();
        String name = model.getTitle();
        String photo = model.getIcon();
        Double lat = model.getLatitude();
        Double lng = model.getLongitude();
        float rating = RatingUtil.calculateRate(model.getLocationRate(), model.getServiceRate(), model.getComfortRate());
        FragmentUtil.replaceFragment(getActivity(), PlaceInfoFragment.class, BundleUtil.getBundle(id.intValue(), lat, lng), true);
//        openMap();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

//        if (requestCode == 1) {

        Log.e("REQUEST CODE", "Apply filter in fragment");


//        }


    }


}
