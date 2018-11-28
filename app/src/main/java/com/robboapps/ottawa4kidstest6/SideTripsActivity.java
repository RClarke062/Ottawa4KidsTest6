package com.robboapps.ottawa4kidstest6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SideTripsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_trips);

        Toast.makeText(this, getIntent().getStringExtra("str1"), Toast.LENGTH_SHORT).show();
    }
}
