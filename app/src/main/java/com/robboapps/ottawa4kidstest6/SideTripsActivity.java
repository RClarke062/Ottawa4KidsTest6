package com.robboapps.ottawa4kidstest6;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;


public class SideTripsActivity extends FragmentActivity implements OnMapReadyCallback
        /*GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener*/ {

    GoogleMap mMap;
    FusedLocationProviderClient mFusedLocationClient;
    String[] outsidestuffchoice;
    String[] Options = new String[7];
    String[] LatLongStringParsed = new String[2];
    String Choice;
    String LatLongString;
    String LatString;
    String LongString;
    double LatNum;
    double LongNum;
    String origin = "25 Willard St, Ottawa, ON K1S 1T4";
    String destination = "450 Queen Elizabeth Dr, Ottawa, ON K1S 3W7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_trips);

        Choice = getIntent().getStringExtra("str1");
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        outsidestuffchoice = getResources().getStringArray(R.array.outsidestuff_array);
        for (int i = 0; i < outsidestuffchoice.length; i++) {
            Options = outsidestuffchoice[i].split(",");
            if (Options[2].equals(Choice)) {
                LatLongString = Options[4];
            }
        }

        LatLongStringParsed = LatLongString.split("\\|");
        LatString = LatLongStringParsed[0];
        LongString = LatLongStringParsed[1];
        LatNum = Double.parseDouble(LatString);
        LongNum = Double.parseDouble(LongString);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
/*
    @Override
    public void onConnected(Bundle bundle) {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);

        } else {
            mMap.setMyLocationEnabled(false);
            Toast.makeText(this, "Please turn on location permissions so we can help you find your way to" + Choice, Toast.LENGTH_SHORT).show();
        }

        mFusedLocationClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            double lat = location.getLatitude();
                            double lng = location.getLongitude();
                        }
                    }
                });
    }

    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }
*/
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
        LatLng ChoiceMarker = new LatLng(LatNum, LongNum);
        Marker marker = mMap.addMarker(new MarkerOptions().position(ChoiceMarker).title(Choice));
        marker.showInfoWindow();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ChoiceMarker, 15));
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);

        } else {
            mMap.setMyLocationEnabled(false);
            Toast.makeText(this, "Please turn on location permissions so we can show you Adult Side Trips!", Toast.LENGTH_SHORT).show();
        }

    }
}