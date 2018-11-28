package com.robboapps.ottawa4kidstest6;

/**
 * Created by rclarke on 3/10/2018.
 */


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ButtonToDirections extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //---Inflate the layout for this fragment---
        return inflater.inflate(
                R.layout.button_to_directions, container, false);
    }

}
