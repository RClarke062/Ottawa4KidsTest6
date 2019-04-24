package com.robboapps.ottawa4kidstest6;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterForFourth extends BaseAdapter {
    private final Context context;
    private final String[] values;

    public AdapterForFourth(Context context, String[] values) {
        this.context = context;
        this.values = values;
    }

    @Override
    public int getCount() {
        return values.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.fourth_adapter, viewGroup, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView2);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        imageView.setImageResource(R.drawable.b);
        textView.setText(values[i]);

        switch (values[i]) {

            case ("WebSite"):
                view.setBackgroundColor(Color.parseColor("#e0af1f"));
                break;

            case ("Where is It"):
                view.setBackgroundColor(Color.parseColor("#e0af1f"));
                break;

            case ("Side Trips for Adults"):
                view.setBackgroundColor(Color.parseColor("#ba160c"));
                break;

            case ("Whats Cool"):
                view.setBackgroundColor(Color.parseColor("#ff00ff"));
                break;

        }
        return view;
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
