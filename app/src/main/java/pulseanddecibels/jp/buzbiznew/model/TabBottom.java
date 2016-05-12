package pulseanddecibels.jp.buzbiznew.model;

import android.util.Log;

/**
 * Created by Diarmaid Lindsay on 2016/04/18.
 * Copyright Pulse and Decibels 2016
 *
 * Represent the bottom tabs in the main activity
 */
public enum TabBottom {
    CONTACTS(0),
    HISTORY(1),
    DIALPAD(2);

    int index;

    TabBottom(int index) {
        this.index = index;
    }

    public static TabBottom getTab(int index) {
        for(TabBottom tabBottom : TabBottom.values()) {
            if(tabBottom.index == index) {
                return tabBottom;
            }
        }

        Log.e("TabBottom", "No matching Tab found!! Returning default tab");
        return CONTACTS;
    }

    public int getIndex() {
        return index;
    }
}
