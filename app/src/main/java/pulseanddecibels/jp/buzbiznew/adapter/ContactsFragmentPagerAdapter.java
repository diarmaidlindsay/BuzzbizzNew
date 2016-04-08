package pulseanddecibels.jp.buzbiznew.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import pulseanddecibels.jp.buzbiznew.fragment.ContactsFragment;

/**
 * Created by Diarmaid Lindsay on 2016/04/07.
 * Copyright Pulse and Decibels 2016
 */
public class ContactsFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;

    private Context context;

    public ContactsFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        return ContactsFragment.newInstance(position + 1);
    }
}
