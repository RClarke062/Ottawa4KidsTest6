package com.robboapps.ottawa4kidstest6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebSiteActivity extends AppCompatActivity {

    String[] outsidestuffchoice;
    String[] Options = new String[6];
    String Url;
    String VendorChoice;
    String activityCategory;
    String[] categoryArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_site);

        final Bundle extras = getIntent().getExtras();
        VendorChoice = extras.getString("VENDORCHOICE");
        activityCategory = extras.getString("ACTIVITYCATEGORY");
        System.out.println("XANADU56b  " + VendorChoice);

        switch (activityCategory){

            case ("Indoor Action"):
                categoryArray = getResources().getStringArray(R.array.indooraction_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        Url = Options[3];
                    }
                }
                break;

            case ("Outdoor Action"):
                categoryArray = getResources().getStringArray(R.array.outsidestuff_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        Url = Options[3];
                    }
                }
                break;

            case ("Educate Me!"):
                categoryArray = getResources().getStringArray(R.array.educateme_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        Url = Options[3];
                    }
                }
                break;

            case ("Shop till you Drop"):
                categoryArray = getResources().getStringArray(R.array.shoptillyoudrop_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        Url = Options[3];
                    }
                }
                break;

            case ("Time to Eat!"):
                categoryArray = getResources().getStringArray(R.array.timetoeat_array);
                for (int i = 0; i < categoryArray.length; i++) {
                    Options = categoryArray[i].split(",");
                    if (Options[2].equals(VendorChoice)) {
                        Url = Options[3];
                    }
                }
                break;
        }

        /*
        outsidestuffchoice = getResources().getStringArray(R.array.outsidestuff_array);
        for (int i = 0; i < outsidestuffchoice.length; i++) {
            Options = outsidestuffchoice[i].split(",");
            if (Options[2].equals(VendorChoice)) {
                Url = Options[3];
            }
        }
        */
        WebView myWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl(Url);

        //Toast.makeText(this, getIntent().getStringExtra("str1"), Toast.LENGTH_SHORT).show();
    }
}
