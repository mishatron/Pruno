package com.hack.apps.starter.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hack.apps.starter.R;
import com.hack.apps.starter.util.Constants;
import com.hack.apps.starter.util.Permissions;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    public static String TAG = "MapActivity";
    private GoogleMap mMap;
    private Double lat;
    private Double lng;
    private String title;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.map_view)
    com.google.android.gms.maps.MapView mMapView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this); //this is important

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            lat = bundle.getDouble(Constants.KEY_LAT);
            Log.e(TAG, "lat=" + lat);
            lng = bundle.getDouble(Constants.KEY_LNG);
            toolbar.setTitle( bundle.getString(Constants.KEY_TITLE));
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        if (!Permissions.isLocationGranted(this)) {
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
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
