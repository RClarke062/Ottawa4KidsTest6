package com.robboapps.ottawa4kidstest6;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
//use arrayadaptor instead?
public class AdapterForFourth extends ArrayAdapter<String> {
    //private final Context context;
    //private final ArrayList<String> values;
    String value2;

    public AdapterForFourth(Context context, ArrayList<String> values) {
        super(context, 0, values);
        //this.context = context;
        //this.values = values;
    }

    //ArrayList<String> valuesLocal = values;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fourth_adapter, parent, false);
        }

        String value = getItem(position);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView2);
        TextView textView = (TextView) convertView.findViewById(R.id.textView);
        imageView.setImageResource(R.drawable.b);
        textView.setText(value);
        //textView.setOnClickListener(new View.OnClickListener() {
        textView.setTag(position);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = (Integer) view.getTag();
                // Access the row position here to get the correct data item
                value2 = getItem(position);
                System.out.println("FLIPPER what was clicked  " + value2);
            }
        });

        switch (value2) {

            case ("WebSite"):
                convertView.setBackgroundColor(Color.parseColor("#e0af1f"));
                break;

            case ("Where is It"):
                convertView.setBackgroundColor(Color.parseColor("#e0af1f"));
                break;

            case ("Side Trips for Adults"):
                convertView.setBackgroundColor(Color.parseColor("#ba160c"));
                break;

            case ("Whats Cool"):
                convertView.setBackgroundColor(Color.parseColor("#ff00ff"));
                break;

        }

        return convertView;
    }
}

    //@Override
    //public View getView(int position, View convertView, ViewGroup parent) {
        //LayoutInflater inflater = (LayoutInflater) context
                //.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //View rowView = inflater.inflate(R.layout.activity_fourth, parent, false);
        //TextView textView = (TextView) rowView.findViewById(R.id.label);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        //textView.setText(values[position]);

        // Change icon based on name
        //String s = values[position];

        //if (s.equals("WebSite")) {
            //rowView.setBackgroundColor(Color.parseColor("#e0af1f"));
        //} else if (s.equals("Where is It")) {
            //rowView.setBackgroundColor(Color.parseColor("#00ff00"));
        //} else if (s.equals("Side Trips for Adults")) {
            //rowView.setBackgroundColor(Color.parseColor("#ba160c"));
        //} else if (s.equals("Whats Cool")) {
            //rowView.setBackgroundColor(Color.parseColor("#ff00ff"));
        //}else {
            //rowView.setBackgroundColor(Color.parseColor("#00ff00"));
        //}

        //System.out.println(s);

        //return rowView;
