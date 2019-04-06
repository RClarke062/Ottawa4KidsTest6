package com.robboapps.ottawa4kidstest6;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterForFourth extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;



    public AdapterForFourth(Context context, String[] values) {
        super(context, R.layout.activity_fourth, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_fourth, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        //ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        textView.setText(values[position]);

        // Change icon based on name
        String s = values[position];

        if (s.equals("WebSite")) {
            rowView.setBackgroundColor(Color.parseColor("#e0af1f"));
        } else if (s.equals("Where is It")) {
            rowView.setBackgroundColor(Color.parseColor("#00ff00"));
        } else if (s.equals("Side Trips for Adults")) {
            rowView.setBackgroundColor(Color.parseColor("#ba160c"));
        } else if (s.equals("Whats Cool")) {
            rowView.setBackgroundColor(Color.parseColor("#ff00ff"));
        }else {
            rowView.setBackgroundColor(Color.parseColor("#00ff00"));
        }

        System.out.println(s);

        return rowView;
    }
}