package com.hack.apps.starter.dashboard;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hack.apps.starter.R;
import com.hack.apps.starter.util.Constants;
import com.hack.apps.starter.util.Permissions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    public static String TAG = "MapFragment";
    private GoogleMap mMap;
    private Double lat;
    private Double lng;
    private String title;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.map_view)
    com.google.android.gms.maps.MapView mMapView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_map, null);

        ButterKnife.bind(this, view);

//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this); //this is important


        Bundle bundle = getArguments();
        if (bundle != null) {
            lat = bundle.getDouble(Constants.KEY_LAT);
            Log.e(TAG, "lat=" + lat);
            lng = bundle.getDouble(Constants.KEY_LNG);
            toolbar.setTitle(bundle.getString(Constants.KEY_TITLE));
        }
        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (!Permissions.isLocationGranted(getActivity())) {
            Log.e(TAG, "Location not granted");
            return;
        }
        mMap = googleMap;

        LatLng marker = new LatLng(lat, lng);
        mMap.addMarker(new MarkerOptions().position(marker)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marker, 15));
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mMapView != null) {
            mMapView.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }
}
