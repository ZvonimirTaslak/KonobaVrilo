package com.taslak.konobavrilo;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static LatLng LAT_LNG_KONOBA_VRILO = new LatLng(43.0951475, 17.6186019);
    private static final float INIT_ZOOM_LEVEL = 10.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        configureMap();
        addMarket(LAT_LNG_KONOBA_VRILO);
        setAdapter();
        animateCamera(LAT_LNG_KONOBA_VRILO);

    }

    private void setAdapter() {
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View v = getLayoutInflater().inflate(R.layout.info_window, null);
                ImageView ivMarkerIcon = (ImageView) v.findViewById(R.id.ivMarkerIcon);
                TextView tvMarkerText = (TextView) v.findViewById(R.id.tvMarketText);

                ivMarkerIcon.setImageResource(R.mipmap.ic_launcher);
                tvMarkerText.setText("Konoba Vrilo \nPRUD - METKOVIĆ");
                return v;
            }
        });

    }

    private void configureMap() {
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setTrafficEnabled(true);


    }

    private void addMarket(LatLng latLngZagreb) {
        mMap.addMarker(new MarkerOptions()
                .position(latLngZagreb)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_favorite_black_24dp)));


    }

    private void animateCamera(LatLng latLngZagreb) {
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLngZagreb, INIT_ZOOM_LEVEL));
    }
}