package pulseanddecibels.jp.buzbiznew.model;

import android.util.Log;

/**
 * Created by Diarmaid Lindsay on 2016/04/18.
 * Copyright Pulse and Decibels 2016
 *
 * Represent the top tabs in the main activity for the bottom history tab
 */
public enum TabTopHistory {
    CALL_BOTH(0),
    CALL_OUT(1),
    CALL_IN(2);

    private int index;

    TabTopHistory(int index) {
        this.index = index;
    }

    public static TabTopHistory getTab(int index) {
        for(TabTopHistory tabTopHistory : TabTopHistory.values()) {
            if(tabTopHistory.getIndex() == index) {
                return tabTopHistory;
            }
        }

        Log.e("TabTopHistory", "No matching Tab found!! Returning default tab");
        return CALL_BOTH;
    }

    public int getIndex() {
        return index;
    }
}
