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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.maps.DirectionsApi;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.Duration;
import com.google.maps.model.TravelMode;

import java.io.IOException;
import java.util.Locale;

public class WhereActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private GoogleMap mMap;
    private FusedLocationProviderClient mFusedLocationClient;
    String[] outsidestuffchoice;
    String[] Options = new String[7];
    String[] LatLongStringParsed = new String[2];
    String Choice;
    String LatLongString;
    String LatString;
    String LongString;
    double LatNum;
    double LongNum;
    String howLongWalking;
    String origin = "25 Willard St, Ottawa, ON K1S 1T4";
    String destination = "450 Queen Elizabeth Dr, Ottawa, ON K1S 3W7";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where);

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
    public void onConnectionSuspended(int i) {}

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {}
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

        // Add a marker at "Choice" location and move the camera to zoom in on area
        com.google.android.gms.maps.model.LatLng ChoiceMarker = new com.google.android.gms.maps.model.LatLng(LatNum, LongNum);
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
            Toast.makeText(this, "Please turn on location permissions so we can help you find your way to" + Choice, Toast.LENGTH_SHORT).show();
        }

        //Toast.makeText(this,String.valueOf(LatNum), Toast.LENGTH_SHORT).show();

        try{
        howLongWalking = getDurationForRoute(origin, destination);
        }catch ( ApiException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, howLongWalking, Toast.LENGTH_SHORT).show();
        TextView walkingDistanceTxtView = (TextView)findViewById(R.id.walkingDistance);
        walkingDistanceTxtView.setText(howLongWalking);
    }

//get duration between origin and destination using architecture component com.google.maps:google-maps-services:0.2.5 added to gradle.build to access google maps directions web services api

    public String getDurationForRoute(String origin, String destination)throws ApiException, InterruptedException, IOException {
    // - get context to access the API
    GeoApiContext geoApiContext = new GeoApiContext.Builder()
            .apiKey("AIzaSyDd-34bsA47300XiOQOYmoe7YXWmfg_AzU")
            .build();

    // - Perform the actual request
    DirectionsResult directionsResult = DirectionsApi.newRequest(geoApiContext)
            .mode(TravelMode.WALKING)
            .origin(origin)
            .destination(destination)
            .await();

    // - Parse the result
    DirectionsRoute route = directionsResult.routes[0];
    DirectionsLeg leg = route.legs[0];
    Duration duration = leg.duration;
    return duration.humanReadable;
    }

//-------------------------------------

    // Launch Google Maps to find directions to Choice
    public void onClick (View view){

        String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", LatNum, LongNum, Choice);
        Uri gmmIntentUri = Uri.parse(uri);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }

    }
}
