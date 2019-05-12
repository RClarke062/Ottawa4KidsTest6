package com.robboapps.ottawa4kidstest6;

import android.content.res.AssetManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import java.io.IOException;
import java.util.Arrays;

public class WhatsCoolActivity extends FragmentActivity {
    ViewPager viewPager;
    CoolSwipeAdaptor swipeAdaptor;
    String WhichActivity;
    String[] imgList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whats_cool);
        viewPager = findViewById(R.id.view_pager);
        System.out.println("XANADU First");
        WhichActivity = getIntent().getStringExtra("str1");
        System.out.println("XANADU What was Sent" + WhichActivity);
        getActionBar().setTitle(WhichActivity);
        swipeAdaptor = new CoolSwipeAdaptor(getSupportFragmentManager());
        viewPager.setAdapter(swipeAdaptor);
        //Toast.makeText(this, getIntent().getStringExtra("str1"), Toast.LENGTH_SHORT).show();
    }

    public class CoolSwipeAdaptor extends FragmentStatePagerAdapter {

        public CoolSwipeAdaptor(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {

        try {

                AssetManager assetManager = getAssets();
                imgList = assetManager.list(WhichActivity);
                System.out.println("XANADU 02" + Arrays.toString(imgList));

            }catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("XANADU 01");
            return imgList.length;

        }

        @Override
        public Fragment getItem(int pos) {
            System.out.println("XANADU 02  POS IS " + pos);

            switch (pos) {
                case 0:
                    return CoolPageFragment.newInstance(0, WhichActivity);
                case 1:
                    return CoolPageFragment.newInstance(1, WhichActivity);
                case 2:
                    return CoolPageFragment.newInstance(2, WhichActivity);
                case 3:
                    return CoolPageFragment.newInstance(3, WhichActivity);
                case 4:
                    return CoolPageFragment.newInstance(4, WhichActivity);

                    default:
                        return null;
            }

        }
}
}
