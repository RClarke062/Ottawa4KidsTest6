package com.robboapps.ottawa4kidstest6;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashSet;

public class ThirdActivity extends ListActivity {

    String[] outsidestuffchoice;
    String[] Options = new String[7];
    String[] Row;
    Integer Count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView lstView = getListView();
        lstView.setTextFilterEnabled(true);
        outsidestuffchoice = getResources().getStringArray(R.array.outsidestuff_array);
        for (int i = 0; i < outsidestuffchoice.length; i++) {
            Options = outsidestuffchoice[i].split(",");
            if (Options[1].equals(getIntent().getStringExtra("str1"))) {
               Count = Count + 1;
            }
        }

        Row = new String[Count];
         Count = 0;

        for (int a = 0; a < outsidestuffchoice.length; a++) {
            Options = outsidestuffchoice[a].split(",");
            if (Options[1].equals(getIntent().getStringExtra("str1"))) {
                Row[Count] = Options[2];
                Count = Count + 1;
            }
        }

        String[] DisplayRow = new HashSet<String>(Arrays.asList(Row)).toArray(new String[0]);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, DisplayRow));

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent,View v, int position, long id){
                String  itemValue    = (String) lstView.getItemAtPosition(position);
                Intent i = new Intent("com.robboapps.ottawa4kidstest6.FourthActivity");
                //---use putExtra() to add new nam/value pairs---
                i.putExtra("str1", itemValue);
                startActivity(i);
            }
        });
    }

}
