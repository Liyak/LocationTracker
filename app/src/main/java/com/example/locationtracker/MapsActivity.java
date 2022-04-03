package com.example.location_tracker;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
/**
 * Created by LiyaK on 03-04-2022.
 */

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap = googleMap;
        LatLng latlng = new LatLng(10.8505, 76.2711);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latlng));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 4.3f));
        mMap.getUiSettings().setScrollGesturesEnabled(true);
        mMap.getUiSettings().setTiltGesturesEnabled(false);
        mMap.getUiSettings().setRotateGesturesEnabled(false);
        setUpMapIfNeeded();
    }
    private void setUpMapIfNeeded() {

        if (mMap != null) {
            setUpMap();
        }

    }

    /*To create the Marker*/
    private void setUpMap() {
        Marker kochi = mMap.addMarker(new MarkerOptions().position(new LatLng(9.9312, 76.2673)).title("Kochi"));
        Marker coimbatore = mMap.addMarker(new MarkerOptions().position(new LatLng(11.0168, 76.9558)).title("Coimbatore"));
        Marker madurai = mMap.addMarker(new MarkerOptions().position(new LatLng(9.9252, 78.1198)).title("Madurai"));
        Marker munnar = mMap.addMarker(new MarkerOptions().position(new LatLng(10.0889, 77.0595)).title("Munnar"));

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(kochi.getPosition());
        builder.include(coimbatore.getPosition());
        builder.include(madurai.getPosition());
        builder.include(munnar.getPosition());
        mOrigin = kochi.getPosition();
        mDestination = munnar.getPosition();
        drawRoute();

    }
}