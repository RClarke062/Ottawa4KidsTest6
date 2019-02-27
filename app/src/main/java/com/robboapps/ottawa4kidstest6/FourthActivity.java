package com.robboapps.ottawa4kidstest6;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.Arrays;


public class FourthActivity extends ListActivity {

    String[] details;
    String VendorChoice;
    String SelectionOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Bundle extras = getIntent().getExtras();
        VendorChoice = extras.getString("VENDORCHOICE");
        SelectionOptions = extras.getString("SELECTIONOPTIONS");
        System.out.println("XANADU56b  " + VendorChoice + SelectionOptions);

        final ListView lstView = getListView();
        lstView.setTextFilterEnabled(true);

        //details = getResources().getStringArray(R.array.allitems_array);

switch (SelectionOptions){

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
        //Toast.makeText(this, getIntent().getStringExtra("str1"), Toast.LENGTH_SHORT).show();

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, details));

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                String itemValue = (String) lstView.getItemAtPosition(position);

                switch (itemValue) {

                    case "WebSite":
                        Intent i = new Intent("com.robboapps.ottawa4kidstest6.WebSiteActivity");
                        //---use putExtra() to send the ThirdActivity choice to the WebSite Activity---
                        //Bundle extras = getIntent().getExtras();
                        i.putExtra("str1", VendorChoice);
                        startActivity(i);
                        break;
                    case "Where is It":
                        Intent a = new Intent("com.robboapps.ottawa4kidstest6.WhereActivity");
                        //---use putExtra() to send the ThirdActivity choice to the Where Activity---
                        //Bundle extras2 = getIntent().getExtras();
                        //extras.putString("VENDORCHOICE", VendorChoice);
                        //extras.putString("SELECTIONOPTIONS", SelectionOptions);
                        a.putExtra("str1", VendorChoice);
                        startActivity(a);
                        break;
                    case "Side Trips for Adults":
                        Intent b = new Intent("com.robboapps.ottawa4kidstest6.SideTripsActivity");
                        //---use putExtra() to send the ThirdActivity choice to the SideTrips Activity---
                        //extras.putString("VENDORCHOICE", VendorChoice);
                        //extras.putString("SELECTIONOPTIONS", SelectionOptions);
                        b.putExtra("str1", VendorChoice);
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
