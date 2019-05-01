package com.robboapps.ottawa4kidstest6;


import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class FourthActivity extends Activity {

    String[] details;
    String VendorChoice;
    String SelectionOptions;
    String activityCategory;
    ArrayList<String> detailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        final ListView listView = findViewById(R.id.list);
        //TextView textView = findViewById(R.id.textView2);
        ImageView imageView = findViewById(R.id.imageView2);
        final Bundle extras = getIntent().getExtras();
        VendorChoice = extras.getString("VENDORCHOICE");
        SelectionOptions = extras.getString("SELECTIONOPTIONS");
        activityCategory = extras.getString("ACTIVITYCATEGORY");
        System.out.println("XANADU56b  " + VendorChoice + SelectionOptions);

        //final ListView lstView = getListView();
        //lstView.setTextFilterEnabled(true);


        switch (SelectionOptions) {

            case ("all"):
                details = getResources().getStringArray(R.array.allitems_array);
                break;
            case ("threeA"):
                details = getResources().getStringArray(R.array.threeitemsA_array);
                break;
            case ("threeB"):
                details = getResources().getStringArray(R.array.threeitemsB_array);
                break;
            case ("one"):
                details = getResources().getStringArray(R.array.oneitem_array);
                break;
        }
        System.out.println("XANADU56c  " + Arrays.toString(details));
        detailsList = new ArrayList<String>(Arrays.asList(details));
        //Toast.makeText(this, getIntent().getStringExtra("str1"), Toast.LENGTH_SHORT).show();

        //setListAdapter(new AdapterForFourth(this, details));

        AdapterForFourth adapterForFourth = new AdapterForFourth(this, detailsList);
        listView.setAdapter(adapterForFourth);
        System.out.println("FLIPPER1  ");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //int itemPosition = position;
                String itemValue = (String) listView.getItemAtPosition(position);
                //String itemValue = (String) listView.getItemIdAtPosition(position);
                //String itemValue = "WebSite";
                System.out.println("FLIPPER 5 " + itemValue );

                switch (itemValue) {

                    case "WebSite":
                        Intent i = new Intent("com.robboapps.ottawa4kidstest6.WebSiteActivity");
                        //---use putExtra() to send the ThirdActivity choice to the WebSite Activity---
                        //Bundle extras = getIntent().getExtras();
                        Bundle extras = new Bundle();
                        extras.putString("VENDORCHOICE", VendorChoice);
                        extras.putString("ACTIVITYCATEGORY", activityCategory);
                        i.putExtras(extras);
                        startActivity(i);
                        break;
                    case "Where is It":
                        Intent a = new Intent("com.robboapps.ottawa4kidstest6.WhereActivity");
                        //---use putExtra() to send the ThirdActivity choice to the Where Activity---
                        //Bundle extras2 = getIntent().getExtras();
                        //extras.putString("VENDORCHOICE", VendorChoice);
                        //extras.putString("SELECTIONOPTIONS", SelectionOptions);
                        //a.putExtra("str1", VendorChoice);
                        Bundle extras2 = new Bundle();
                        extras2.putString("VENDORCHOICE", VendorChoice);
                        extras2.putString("ACTIVITYCATEGORY", activityCategory);
                        a.putExtras(extras2);
                        startActivity(a);
                        break;
                    case "Side Trips for Adults":
                        Intent b = new Intent("com.robboapps.ottawa4kidstest6.SideTripsActivity");
                        //---use putExtra() to send the ThirdActivity choice to the SideTrips Activity---
                        //extras.putString("VENDORCHOICE", VendorChoice);
                        //extras.putString("SELECTIONOPTIONS", SelectionOptions);
                        //b.putExtra("str1", VendorChoice);
                        Bundle extras3 = new Bundle();
                        extras3.putString("VENDORCHOICE", VendorChoice);
                        extras3.putString("ACTIVITYCATEGORY", activityCategory);
                        b.putExtras(extras3);
                        startActivity(b);
                        break;
                    case "Whats Cool":
                        Intent c = new Intent("com.robboapps.ottawa4kidstest6.WhatsCoolActivity");
                        //---use putExtra() to send the ThirdActivity choice to the WhatsCool Activity---
                        //extras.putString("VENDORCHOICE", VendorChoice);
                        //extras.putString("SELECTIONOPTIONS", SelectionOptions);
                        c.putExtra("str1", VendorChoice);
                        startActivity(c);
                        break;
                }
            }
        });
    }
}
