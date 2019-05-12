package com.robboapps.ottawa4kidstest6;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class SideTripsActivity extends FragmentActivity implements OnMapReadyCallback
       /* ,GoogleApiClient.ConnectionCallbacks , GoogleApiClient.OnConnectionFailedListener*/{

    private static final int PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 0 ;
    GoogleMap mMap;
    FusedLocationProviderClient mFusedLocationClient;
    String[] outsidestuffchoice;
    String[] SideTripsRegions;
    String[] SideTripsMarker = new String[3];
    String[] Options = new String[6];
    String[] LatLongStringParsed = new String[2];
    String[] categoryArray;
    //String Choice;
    String SideTripsKey;
    String LatLongString;
    double LatNum;
    double LongNum;
    String LatStringST;
    String LongStringST;
    String VendorChoice;
    String activityCategory;
    double LatNumST;
    double LongNumST;
    private List<Marker> markerList = new ArrayList<>();
    boolean mLocationPermissionGranted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_trips);
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println("ZIPPY" + month);

        final Bundle extras = getIntent().getExtras();
        VendorChoice = extras.getString("VENDORCHOICE");
        activityCategory = extras.getString("ACTIVITYCATEGORY");
        getActionBar().setTitle(VendorChoice);
        System.out.println("XANADU56b choice and category  " + VendorChoice + activityCategory);

        //Choice = getIntent().getStringExtra("str1");
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        switch (activityCategory){

            case ("Indoor Action"):
                if (month==10){
                    categoryArray = getResources().getStringArray(R.array.indooractionoctober_array);
                }else {
                    categoryArray = getResources().getStringArray(R.array.indooraction_array);
                }
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        LatLongString = Options[4];
                        SideTripsKey = Options[5];
                        System.out.println("XANADU in Outsidestuffchoice" + SideTripsKey);
                        System.out.println("XANADU in Outsidestuffchoice" + VendorChoice);
                    }
                }
                break;

            case ("Outdoor Action"):
                if (month> 4 && month<10){
                    categoryArray = getResources().getStringArray(R.array.outdooractionsummer_array);
                }else {
                    categoryArray = getResources().getStringArray(R.array.outdooractionwinter_array);
                }
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        LatLongString = Options[4];
                        SideTripsKey = Options[5];
                        System.out.println("XANADU in Outsidestuffchoice" + SideTripsKey);
                        System.out.println("XANADU in Outsidestuffchoice" + VendorChoice);
                    }
                }
                break;

            case ("Educate Me!"):
                categoryArray = getResources().getStringArray(R.array.educateme_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        LatLongString = Options[4];
                        SideTripsKey = Options[5];
                        System.out.println("XANADU in Outsidestuffchoice" + SideTripsKey);
                        System.out.println("XANADU in Outsidestuffchoice" + VendorChoice);
                    }
                }
                break;

            case ("Shop till you Drop"):
                categoryArray = getResources().getStringArray(R.array.shoptillyoudrop_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        LatLongString = Options[4];
                        SideTripsKey = Options[5];
                        System.out.println("XANADU in Outsidestuffchoice" + SideTripsKey);
                        System.out.println("XANADU in Outsidestuffchoice" + VendorChoice);
                    }
                }
                break;

            case ("Time to Eat!"):
                categoryArray = getResources().getStringArray(R.array.timetoeat_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        LatLongString = Options[4];
                        SideTripsKey = Options[5];
                        System.out.println("XANADU in Outsidestuffchoice" + SideTripsKey);
                        System.out.println("XANADU in Outsidestuffchoice" + VendorChoice);
                    }
                }
                break;
        }
/*
        outsidestuffchoice = getResources().getStringArray(R.array.outsidestuff_array);
        for (int i = 0; i < outsidestuffchoice.length; i++) {
            Options = outsidestuffchoice[i].split(",");
            if (Options[2].equals(Choice)) {
                LatLongString = Options[4];
                SideTripsKey = Options[5];
                System.out.println("XANADU in Outsidestuffchoice" + SideTripsKey);
                System.out.println("XANADU in Outsidestuffchoice" + Choice);
            }
        }
*/
        LatLongStringParsed = LatLongString.split("\\|");
        LatNum = Double.parseDouble(LatLongStringParsed[0]);
        LongNum = Double.parseDouble(LatLongStringParsed[1]);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void getLocationPermission() {

        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;
            updateLocationUI();
        } else {
            requestPermissions(
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true;
                }
            }
        }
        System.out.println("XANADU Did permission callback get called");
        updateLocationUI();
    }

    private void updateLocationUI() {
        System.out.println("XANADU did it get to updateLocationUI");
        if (mMap == null) {
            System.out.println("XANADU was it null");
            return;
        }
        try {
            if (mLocationPermissionGranted) {
                mMap.setMyLocationEnabled(true);
                //add current location to the marker list to included in field of view
                Location location;
                LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location != null) {
                    LatLng latLngCurrent = new LatLng(location.getLatitude(),
                            location.getLongitude());
                    Marker marker3 = mMap.addMarker(new MarkerOptions().position(latLngCurrent).visible(false));
                    markerList.add(marker3);
                }
                System.out.println("XANADU was it true");

            } else {
                mMap.setMyLocationEnabled(false);
                System.out.println("XANADU was it false");
            }
        } catch (SecurityException e)  {
            Log.e("Exception: %s", e.getMessage());
            System.out.println("XANADU was there a security exception");
        }
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
        //add marker for location of destination
        mMap = googleMap;
        getLocationPermission();

        LatLng ChoiceMarker = new LatLng(LatNum, LongNum);
        Marker marker = mMap.addMarker(new MarkerOptions().position(ChoiceMarker).title(VendorChoice));
        marker.showInfoWindow();
        markerList.add(marker);

        //add sidtrips markers
        SideTripsRegions = getResources().getStringArray(R.array.sidetrips_array);
        for (int i = 0; i < SideTripsRegions.length; i++) {
            String[] SideTripsLocations = SideTripsRegions[i].split(",");
            System.out.println("XANADU in onMapReady" + SideTripsKey);
            if (SideTripsLocations[0].equals(SideTripsKey)) {
                for (int x = 1; x < SideTripsLocations.length; x++) {
                    SideTripsMarker = SideTripsLocations[x].split("\\|");
                    LatStringST = SideTripsMarker[1];
                    LongStringST = SideTripsMarker[2];
                    LatNumST = Double.parseDouble(LatStringST);
                    LongNumST = Double.parseDouble(LongStringST);
                    LatLng ChoiceMarkerST = new LatLng(LatNumST, LongNumST);
                    Marker marker2 = mMap.addMarker(new MarkerOptions().position(ChoiceMarkerST).title(SideTripsMarker[0]));
                    marker2.showInfoWindow();
                    marker2.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
                    markerList.add(marker2);
                }
            }
        }
        LatLngBounds.Builder b = new LatLngBounds.Builder();
        for (Marker m : markerList) {
            b.include(m.getPosition());
        }
        LatLngBounds bounds = b.build();
        //int padding = 0; // offset from edges of the map in pixels
        //CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
        //Change the padding as per needed
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, 1000,1000,200);
        mMap.animateCamera(cu);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

    }
}