package pulseanddecibels.jp.buzbiznew.model;

import android.util.Log;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.activity.BuzbizApplication;

/**
 * Created by Diarmaid Lindsay on 2016/04/12.
 * Copyright Pulse and Decibels 2016
 *
 * Represent the top tabs in the main activity for the bottom contact tab
 */
public enum TabTopContact {
    OUTSIDE(R.string.line_outside, 0),
    INSIDE(R.string.line_inside, 1);

    private int resourceId;
    private int index;

    TabTopContact(int resourceId, int index) {
        this.resourceId = resourceId;
        this.index = index;
    }

    public static TabTopContact getTab(int index) {
        for(TabTopContact tabTopContact : TabTopContact.values()) {
            if(tabTopContact.getIndex() == index) {
                return tabTopContact;
            }
        }

        Log.e("TabTopContact", "No matching Tab found!! Returning default tab");
        return OUTSIDE;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return BuzbizApplication.getContext().getString(resourceId);
    }
}
