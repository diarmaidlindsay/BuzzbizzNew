package pulseanddecibels.jp.buzbiznew.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import pulseanddecibels.jp.buzbiznew.fragment.HistoryFragment;

/**
 * Created by Diarmaid Lindsay on 2016/04/06.
 * Copyright Pulse and Decibels 2016
 *
 * https://guides.codepath.com/android/google-play-style-tabs-using-tablayout
 */
public class HistoryFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;

    private Context context;

    public HistoryFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return HistoryFragment.newInstance(position + 1);
    }

}
