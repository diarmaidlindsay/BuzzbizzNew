package pulseanddecibels.jp.buzbiznew.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.adapter.HoldAdapter;

/**
 * Created by Diarmaid Lindsay on 2016/05/18.
 * Copyright Pulse and Decibels 2016
 */
public class HoldActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hold);
        ListView holdList = (ListView) findViewById(R.id.hold_list);
        HoldAdapter holdAdapter = new HoldAdapter(this);
        holdList.setAdapter(holdAdapter);
    }
}
