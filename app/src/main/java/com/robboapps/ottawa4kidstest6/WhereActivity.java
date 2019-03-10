package com.robboapps.ottawa4kidstest6;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

//public class WhereActivity extends FragmentActivity implements OnMapReadyCallback {
public class WhereActivity extends AppCompatActivity {
    GoogleMap mMap;
    String[] outsidestuffchoice;
    String[] Options = new String[6];
    String[] LatLongStringParsed = new String[2];
    String Choice;
    String LatLongString;
    String LatString;
    String LongString;
    String VendorChoice;
    String activityCategory;
    String[] categoryArray;
    double LatNum;
    double LongNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where);

        final Bundle extras = getIntent().getExtras();
        VendorChoice = extras.getString("VENDORCHOICE");
        activityCategory = extras.getString("ACTIVITYCATEGORY");
        System.out.println("XANADU56b choice and category  " + VendorChoice + activityCategory);

        switch (activityCategory){

            case ("Indoor Action"):
                categoryArray = getResources().getStringArray(R.array.indooraction_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        LatLongString = Options[4];
                    }
                }
                break;

            case ("Outdoor Action"):
                categoryArray = getResources().getStringArray(R.array.outsidestuff_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        LatLongString = Options[4];
                    }
                }
                break;

            case ("Educate Me!"):
                categoryArray = getResources().getStringArray(R.array.educateme_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        LatLongString = Options[4];
                        System.out.println("XANADU98  latlong" + LatLongString);
                    }
                }
                break;

            case ("Shop till you Drop"):
                categoryArray = getResources().getStringArray(R.array.shoptillyoudrop_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        LatLongString = Options[4];
                    }
                }
                break;

            case ("Time to Eat!"):
                categoryArray = getResources().getStringArray(R.array.timetoeat_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        LatLongString = Options[4];
                    }
                }
                break;
        }
/*
        Choice = getIntent().getStringExtra("str1");
        //mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        outsidestuffchoice = getResources().getStringArray(R.array.outsidestuff_array);
        for (int i = 0; i < outsidestuffchoice.length; i++) {
            Options = outsidestuffchoice[i].split(",");
            if (Options[2].equals(Choice)) {
                LatLongString = Options[4];
            }
        }
*/
        LatLongStringParsed = LatLongString.split("\\|");
        LatString = LatLongStringParsed[0];
        LongString = LatLongStringParsed[1];
        LatNum = Double.parseDouble(LatString);
        LongNum = Double.parseDouble(LongString);

// gets rid of blank screen when back button pushed

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 100);

        //String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?daddr=%f,%f (%s)", LatNum, LongNum, Choice);
        String uri = String.format(Locale.ENGLISH,"geo:%f,%f?q=%s", LatNum, LongNum, VendorChoice);
        System.out.println("XANADU203  Lat and Long parsed  " + LatNum + LongNum);
        //mMap.addMarker(new MarkerOptions().title(Choice));
        Uri gmmIntentUri = Uri.parse(uri);
        //Uri gmmIntentUri = Uri.parse(LatNum, LongNum + Uri.encode("1st & Pike, Seattle"));
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        //if (mapIntent.resolveActivity(getPackageManager()) != null) {
            //startActivity(mapIntent);

        //}

        try
        {
            startActivity(mapIntent);
        }
        catch(ActivityNotFoundException ex)
        {
            try
            {
                Intent unrestrictedIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(unrestrictedIntent);
            }
            catch(ActivityNotFoundException innerEx)
            {
                Toast.makeText(this, "Please install Google Maps if you'd like to find" +
                        "the location", Toast.LENGTH_LONG).show();
            }
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        //SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                //.findFragmentById(R.id.map);
        //mapFragment.getMapAsync(this);
    }
      /*
    // Launch Google Maps to find directions to Choice
    @Override
    public void onMapReady (GoogleMap googleMap){

        mMap = googleMap;
        LatLng Loc = new LatLng (LatNum, LongNum);
        mMap.addMarker(new MarkerOptions().position(Loc).title(Choice));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Loc, 18));
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
*/
    //}

}
