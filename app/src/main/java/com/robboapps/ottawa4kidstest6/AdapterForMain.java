package com.robboapps.ottawa4kidstest6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterForMain extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;



    public AdapterForMain(Context context, String[] values) {
        super(context, R.layout.activity_main, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_main, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        textView.setText(values[position]);

        // Change icon based on name
        String s = values[position];

        System.out.println(s);

        if (s.equals("Indoor Action")) {
            imageView.setImageResource(R.drawable.indooraction);
        } else if (s.equals("Outdoor Action")) {
            imageView.setImageResource(R.drawable.outdooraction);
        } else if (s.equals("Educate Me!")) {
            imageView.setImageResource(R.drawable.educateme);
        } else if (s.equals("Shop till you Drop")) {
                imageView.setImageResource(R.drawable.shoptillyoudrop);
        } else if (s.equals("Time to Eat!")) {
                imageView.setImageResource(R.drawable.timetoeat);
        }else {
            imageView.setImageResource(R.drawable.b);
        }

        return rowView;
    }
}
