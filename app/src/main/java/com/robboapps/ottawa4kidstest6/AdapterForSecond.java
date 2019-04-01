package com.robboapps.ottawa4kidstest6;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AdapterForSecond extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    AssetManager assetManager;
    String[] imgList;
    int numImages;
    ArrayList<Bitmap> picString = new ArrayList<>();


    public AdapterForSecond(Context context, String[] values) {
        super(context, R.layout.activity_second, values);
        this.context = context;
        this.values = values;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.activity_second, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
        textView.setText(values[position]);


        try {
            //if (getActivity().getAssets() !=null){
            //assetManager = getContext().getAssets();
            //}
            // getAssets has a warning becuase it is possible that the fragment
            // will not be attached to the main activity.  Separate try statement does not
            // get rid of the warning but StackOverflow said not an issue
            assetManager = getContext().getAssets();
            imgList = assetManager.list("A_Types");
            System.out.println("XANADU 03" + Arrays.toString(imgList));
            numImages = imgList.length;
            for (int i = 0; i < imgList.length; i++) {
                picString.add(i, BitmapFactory.decodeStream(assetManager.open("A_Types" +"/" + imgList[i])));
                //System.out.print("XANADU15  " + imgList[i] + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Change icon based on name
        String s = values[position];



        for (int i = 0; i < imgList.length; i++) {
            System.out.println("ZIPPY12  " + s + "  " + imgList[i]);
            if ((s + ".png").equals(imgList[i])) {
                imageView.setImageBitmap(picString.get(i));

            }
            //else {
                //imageView.setImageBitmap(picString.get(0));
            //}
        }
/*
        if (s.equals("Indoor Action")) {
            imageView.setImageResource(R.drawable.b);
        } else if (s.equals("Oudoor Action")) {
            imageView.setImageResource(R.drawable.c);
        } else if (s.equals("Educate Me!")) {
            imageView.setImageResource(R.drawable.d);
        } else if (s.equals("Shop till you Drop")) {
            imageView.setImageResource(R.drawable.d);
        } else if (s.equals("Time to Eat")) {
            imageView.setImageResource(R.drawable.d);
        }else {
            imageView.setImageResource(R.drawable.b);
        }
*/
        return rowView;
    }
}
