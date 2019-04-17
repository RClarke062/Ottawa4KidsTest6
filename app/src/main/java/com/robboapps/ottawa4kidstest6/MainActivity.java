package com.robboapps.ottawa4kidstest6;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class MainActivity extends ListActivity {

    String[] activityCategories;
    ArrayList<String> sortedArrayList;
    //private Toolbar TopToolbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCategories = getResources().getStringArray(R.array.activitycategories_array);
        //TopToolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar (TopToolbar);

        //this is how you build the list and only display the top level item once
        //finds unique elements in the Row Array @ Java 7 level (Java 8 has simpler method)
        String[] DisplayRow = new HashSet<String>(Arrays.asList(activityCategories)).toArray(new String[0]);
        sortedArrayList = new ArrayList<String>(Arrays.asList(DisplayRow));
        Collections.sort(sortedArrayList);
        String[] sortedArray = sortedArrayList.toArray(new String[0]);
        setListAdapter(new AdapterForMain(this, sortedArray));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        //get selected items
        String itemValue = (String) getListAdapter().getItem(position);
        Intent i = new Intent("com.robboapps.ottawa4kidstest6.SecondActivity");
        //---use putExtra() to add new nam/value pairs---
        i.putExtra("str1", itemValue);
        startActivity(i);
        //Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();

    }
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lstView = getListView();
        lstView.setTextFilterEnabled(true);
        activityCategories = getResources().getStringArray(R.array.activitycategories_array);

        //this is how you build the list and only display the top level item once
        //finds unique elements in the Row Array @ Java 7 level (Java 8 has simpler method)
        String[] DisplayRow = new HashSet<String>(Arrays.asList(activityCategories)).toArray(new String[0]);
        //display only unique items
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, DisplayRow));

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent,View v, int position, long id){
                String  itemValue    = (String) lstView.getItemAtPosition(position);
                Intent i = new Intent("com.robboapps.ottawa4kidstest6.SecondActivity");
                //---use putExtra() to add new nam/value pairs---
                i.putExtra("str1", itemValue);
                startActivity(i);
            }
        });
    }
*/
}
