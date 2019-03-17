package com.robboapps.ottawa4kidstest6;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class ThirdActivity extends ListActivity {

    String[] outsidestuffchoice;
    //String[] Options = new String[6];
    String[] Options;
    String[] Row;
    String[] SelectionArray;
    ArrayList<String> selectionArrayList;
    ArrayList<String> sortedArrayList;
    Integer Count = 0;
    String VendorChoice;
    String SelectionOptions;
    String activityType;
    String activityCategory;
    String[] vendorArray;
    ArrayList<String> vendorArrayList;
    String[] categoryArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        System.out.println("ZIPPY" + month);

        final Bundle extras = getIntent().getExtras();
        activityType = extras.getString("ACTIVITYTYPE");
        activityCategory = extras.getString("ACTIVITYCATEGORY");
        System.out.println("XANADU91 activityType =  " + activityType + "activityCategory =  " + activityCategory);

        final ListView lstView = getListView();
        lstView.setTextFilterEnabled(true);

        switch (activityCategory){

            case ("Indoor Action"):
                if (month==10){
                    categoryArray = getResources().getStringArray(R.array.indooractionoctober_array);
                }else {
                    categoryArray = getResources().getStringArray(R.array.indooraction_array);
                }
                vendorArrayList = new ArrayList<>();
                selectionArrayList = new ArrayList<>();
                for (int i = 0; i < categoryArray.length; i++) {
                    Row = categoryArray[i].split(",");
                    if (Row[1].equals(activityType)) {
                        vendorArrayList.add(Row[2]);
                        selectionArrayList.add(Row[6]);
                    }
                    vendorArray = vendorArrayList.toArray(new String[0]);
                    SelectionArray = selectionArrayList.toArray(new String[0]);
                    }
                break;
            case ("Outdoor Action"):
                if (month> 4 && month<10){
                    categoryArray = getResources().getStringArray(R.array.outdooractionsummer_array);
                }else {
                    categoryArray = getResources().getStringArray(R.array.outdooractionwinter_array);
                }
                vendorArrayList = new ArrayList<>();
                selectionArrayList = new ArrayList<>();
                for (int i = 0; i < categoryArray.length; i++) {
                    Row = categoryArray[i].split(",");
                    if (Row[1].equals(activityType)) {
                        vendorArrayList.add(Row[2]);
                        selectionArrayList.add(Row[6]);
                    }
                    vendorArray = vendorArrayList.toArray(new String[0]);
                    SelectionArray = selectionArrayList.toArray(new String[0]);
                }
                break;
            case ("Educate Me!"):
                categoryArray = getResources().getStringArray(R.array.educateme_array);
                vendorArrayList = new ArrayList<>();
                selectionArrayList = new ArrayList<>();
                for (int i = 0; i < categoryArray.length; i++) {
                    Row = categoryArray[i].split(",");
                    System.out.println("XANADU93 type and vendor is  " + Row[1] + Row[2]);
                    if (Row[1].equals(activityType)) {
                        vendorArrayList.add(Row[2]);
                        selectionArrayList.add(Row[6]);
                        System.out.println("XANADU92 type is  " + Row[1]);
                    }
                }
                vendorArray = vendorArrayList.toArray(new String[0]);
                SelectionArray = selectionArrayList.toArray(new String[0]);
                break;
            case ("Shop till you Drop"):
                categoryArray = getResources().getStringArray(R.array.shoptillyoudrop_array);
                vendorArrayList = new ArrayList<>();
                selectionArrayList = new ArrayList<>();
                for (int i = 0; i < categoryArray.length; i++) {
                    Row = categoryArray[i].split(",");
                    if (Row[1].equals(activityType)) {
                        vendorArrayList.add(Row[2]);
                        selectionArrayList.add(Row[6]);
                    }
                    //vendorArray = vendorArrayList.toArray(new String[vendorArrayList.size()]);
                    //SelectionArray = selectionArrayList.toArray(new String[selectionArrayList.size()]);
                    vendorArray = vendorArrayList.toArray(new String[0]);
                    SelectionArray = selectionArrayList.toArray(new String[0]);
                }
                break;
            case ("Time to Eat!"):
                categoryArray = getResources().getStringArray(R.array.timetoeat_array);
                vendorArrayList = new ArrayList<>();
                selectionArrayList = new ArrayList<>();
                for (int i = 0; i < categoryArray.length; i++) {
                    Row = categoryArray[i].split(",");
                    if (Row[1].equals(activityType)) {
                        vendorArrayList.add(Row[2]);
                        selectionArrayList.add(Row[6]);
                    }
                    vendorArray = vendorArrayList.toArray(new String[0]);
                    SelectionArray = selectionArrayList.toArray(new String[0]);
                }
                break;
        }

        /*
        outsidestuffchoice = getResources().getStringArray(R.array.outsidestuff_array);
        for (int i = 0; i < outsidestuffchoice.length; i++) {
            Options = outsidestuffchoice[i].split(",");
            if (Options[1].equals(getIntent().getStringExtra("str1"))) {
               Count = Count + 1;
            }
        }

        Row = new String[Count];
        SelectionArray = new String[Count];
        //outsidestuffchoice = getResources().getStringArray(R.array.outsidestuff_array);

        Count = 0;

        for (int a = 0; a < outsidestuffchoice.length; a++) {
            Options = outsidestuffchoice[a].split(",");
            if (Options[1].equals(getIntent().getStringExtra("str1"))) {
                Row[Count] = Options[2];
                SelectionArray[Count] = Options[6];
                Count = Count + 1;
            }
        }
*/
        Arrays.sort(vendorArray);
        String[] DisplayRow = new HashSet<String>(Arrays.asList(vendorArray)).toArray(new String[0]);
        sortedArrayList = new ArrayList<String>(Arrays.asList(DisplayRow));
        Collections.sort(sortedArrayList);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sortedArrayList));

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent,View v, int position, long id){
                String  itemValue    = (String) lstView.getItemAtPosition(position);
                for (int b = 0; b < vendorArray.length; b++) {
                    if (vendorArray[b].equals(itemValue)) {
                        SelectionOptions = SelectionArray[b];
                    }
                }
                System.out.println("XANADU56itemValue&Option " + itemValue + SelectionOptions);
                Intent i = new Intent("com.robboapps.ottawa4kidstest6.FourthActivity");
                //---use putExtra() to add new nam/value pairs---
                Bundle extras = new Bundle();
                extras.putString("VENDORCHOICE", itemValue);
                extras.putString("SELECTIONOPTIONS", SelectionOptions);
                extras.putString("ACTIVITYCATEGORY", activityCategory);
                i.putExtras(extras);
                startActivity(i);
                //i.putExtra("str1", itemValue);
                //startActivity(i);
            }
        });
    }

}
