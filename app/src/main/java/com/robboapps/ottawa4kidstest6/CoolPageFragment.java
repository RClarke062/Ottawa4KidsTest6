package com.robboapps.ottawa4kidstest6;


import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// change to commit

public class CoolPageFragment extends Fragment{
//public Context mContext;
    //public constructor that gets context via import android.support.v4.app.Fragment for use with Assetmanager class
    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }
    AssetManager assetManager;
    ImageView imageView;
    Integer numImages;
    String[] imgList;
    static String activityTranslate;
    int mPosition;
    ArrayList<Bitmap> picString = new ArrayList<>();

    public static CoolPageFragment newInstance(int pos, String WhichActivity) {
        activityTranslate = WhichActivity;
        CoolPageFragment frag = new CoolPageFragment();
        Bundle args = new Bundle();
        args.putInt("pos", pos);
        frag.setArguments(args);
        return frag;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPosition = getArguments() != null ? getArguments().getInt("pos") : 1;
        System.out.println("XANADU 67  position is " + mPosition);

    }

    @Override
    // add @NonNull to get rid of "not annotated paramter overrides @NonNull" warning
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //assetManager = getContext().getAssets();
        //if (assetManager !=null);
       //if (getActivity() !=null) assetManager = getContext().getAssets();
        //try{
            //if (getActivity() !=null){
                //assetManager = getContext().getAssets();
            //}
        //}catch (IOException e) {
            //e.printStackTrace();
        //}

        try {
            //if (getActivity().getAssets() !=null){
                //assetManager = getContext().getAssets();
            //}
            // getAssets has a warning becuase it is possible that the fragment
            // will not be attached to the main activity.  Separate try statement does not
            // get rid of the warning but StackOverflow said not an issue
            assetManager = getContext().getAssets();
            imgList = assetManager.list(activityTranslate);
            System.out.println("XANADU 03" + Arrays.toString(imgList));
            numImages = imgList.length;
            for (int i = 0; i < imgList.length; i++) {
                picString.add(i, BitmapFactory.decodeStream(assetManager.open(activityTranslate +"/" + imgList[i])));
                System.out.print("XANADU15  " + picString.get(i) + " ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.fragment_cool_page, container, false);
        imageView = view.findViewById(R.id.imageView);

        switch (mPosition) {
            case 0:
                imageView.setImageBitmap(picString.get(0));
                return view;
            case 1:
                imageView.setImageBitmap(picString.get(1));
                return view;
            case 2:
                imageView.setImageBitmap(picString.get(2));
                return view;
            case 3:
                imageView.setImageBitmap(picString.get(3));
                return view;
            case 4:
                imageView.setImageBitmap(picString.get(4));
                return view;
            default:
                imageView.setImageBitmap(picString.get(0));
                return view;
        }

    }
}
