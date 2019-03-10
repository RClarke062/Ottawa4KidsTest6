package com.robboapps.ottawa4kidstest6;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SecondActivity extends ListActivity {

    String[] outsidestuffchoice;
    String[] Options;
    String[] Row;
    String[] Type;
    String[] categoryArray;
    Integer Count = 0;
    String activityCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lstView = getListView();
        lstView.setTextFilterEnabled(true);

        activityCategory = getIntent().getStringExtra("str1");

        switch (activityCategory){

            case ("Indoor Action"):
                categoryArray = getResources().getStringArray(R.array.indooraction_array);
                Type = new String[categoryArray.length];
                for (int i = 0; i < categoryArray.length; i++) {
                    Row = categoryArray[i].split(",");
                    Type[i] = Row[1];
                }
                break;
            case ("Outdoor Action"):
                categoryArray = getResources().getStringArray(R.array.outsidestuff_array);
                Type = new String[categoryArray.length];
                for (int i = 0; i < categoryArray.length; i++) {
                    Row = categoryArray[i].split(",");
                    Type[i] = Row[1];
                }
                break;
            case ("Educate Me!"):
                categoryArray = getResources().getStringArray(R.array.educateme_array);
                Type = new String[categoryArray.length];
                for (int i = 0; i < categoryArray.length; i++) {
                    Row = categoryArray[i].split(",");
                    Type[i] = Row[1];
                }
                break;
            case ("Shop till you Drop"):
                categoryArray = getResources().getStringArray(R.array.shoptillyoudrop_array);
                Type = new String[categoryArray.length];
                for (int i = 0; i < categoryArray.length; i++) {
                    Row = categoryArray[i].split(",");
                    Type[i] = Row[1];
                }
                break;
            case ("Time to Eat!"):
                categoryArray = getResources().getStringArray(R.array.timetoeat_array);
                Type = new String[categoryArray.length];
                for (int i = 0; i < categoryArray.length; i++) {
                    Row = categoryArray[i].split(",");
                    Type[i] = Row[1];
                }
                break;
        }

        /*
        outsidestuffchoice = getResources().getStringArray(R.array.outsidestuff_array);

        for (int i = 0; i < outsidestuffchoice.length; i++) {
            Options = outsidestuffchoice[i].split(",");
            if (Options[0].equals(getIntent().getStringExtra("str1"))) {
                Count = Count + 1;
            }
        }

            Row = new String[Count];
            Count = 0;

            for (int a = 0; a < outsidestuffchoice.length; a++) {
                Options = outsidestuffchoice[a].split(",");
                if (Options[0].equals(getIntent().getStringExtra("str1"))) {
                    Row[Count] = Options[1];
                    Count = Count + 1;
                }
            }

            */
                //finds unique elements in the Row Array @ Java 7 level (Java 8 has simpler method)
                String[] DisplayRow = new HashSet<String>(Arrays.asList(Type)).toArray(new String[0]);
                //display only unique items
                setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, DisplayRow));

                lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                        String itemValue = (String) lstView.getItemAtPosition(position);
                        Intent i = new Intent("com.robboapps.ottawa4kidstest6.ThirdActivity");
                        //---use putExtra() to add new nam/value pairs---
                        //i.putExtra("str1", itemValue);
                        Bundle extras = new Bundle();
                        extras.putString("ACTIVITYTYPE", itemValue);
                        extras.putString("ACTIVITYCATEGORY", activityCategory);
                        i.putExtras(extras);
                        startActivity(i);
                    }
                });
            }

        }

