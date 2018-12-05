package com.robboapps.ottawa4kidstest6;


import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import java.util.Locale;

public class WhereActivity extends FragmentActivity implements OnMapReadyCallback {

    //GoogleMap mMap;
    String[] outsidestuffchoice;
    String[] Options = new String[7];
    String[] LatLongStringParsed = new String[2];
    String Choice;
    String LatLongString;
    String LatString;
    String LongString;
    double LatNum;
    double LongNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where);

        Choice = getIntent().getStringExtra("str1");
        //mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

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

    // Launch Google Maps to find directions to Choice
    @Override
    public void onMapReady (GoogleMap googleMap){

        //mMap = googleMap;
        //LatLng Loc = new LatLng (LatNum, LongNum);
        //mMap.addMarker(new MarkerOptions().position(Loc).title(Choice));
        //mMap.addMarker(new MarkerOptions().title(Choice));
        //String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", LatNum, LongNum, Choice);
        String uri = String.format("geo:%f,%f?q=%s", LatNum, LongNum, Choice);
        //mMap.addMarker(new MarkerOptions().title(Choice));
        Uri gmmIntentUri = Uri.parse(uri);
        //Uri gmmIntentUri = Uri.parse(LatNum, LongNum + Uri.encode("1st & Pike, Seattle"));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);

        }

    }
}
