package com.example.kosta.beautymateandroid.survey;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.util.Log;

import com.example.kosta.beautymateandroid.R;


public class SurveyActivity extends FragmentActivity {

    public SurveyActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        FragmentTabHost tabHost = (FragmentTabHost) findViewById(R.id.tabHost);
        tabHost.setup(this, getSupportFragmentManager(),R.id.realTabContent /*android.R.id.tabcontent*/);
        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator("Part1"), Pt1Survey.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator("Part2"), Pt2Survey.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator("Part3"), Pt3Survey.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator("Part4"), Pt4Survey.class, null);

    }



}
