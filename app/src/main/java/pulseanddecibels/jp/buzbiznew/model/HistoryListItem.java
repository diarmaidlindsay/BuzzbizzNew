package pulseanddecibels.jp.buzbiznew.model;

import pulseanddecibels.jp.buzbiznew.R;

/**
 * Created by Diarmaid Lindsay on 2016/04/12.
 * Copyright Pulse and Decibels 2016
 */
public class HistoryListItem {
    private int telNumber;
    private String time;
    private CallDirection direction;

    public HistoryListItem(int telNumber, String time, CallDirection direction) {
        this.telNumber = telNumber;
        this.time = time;
        this.direction = direction;
    }

    public int getTelNumber() {
        return telNumber;
    }

    public String getTime() {
        return time;
    }

    public CallDirection getDirection() {
        return direction;
    }

    public int getDirectionImage() {
        switch (direction) {
            case IN:
                return R.drawable.history_in_bg;
            case OUT:
                return R.drawable.history_out_bg;
        }

        return android.R.drawable.presence_busy;
    }

    /**
     * Should be determined from the phone/extension number eventually
     * @return
     */
    public TabTopContact getLineType() {
        if(telNumber < 1000) {
            return TabTopContact.INSIDE;
        }
        return TabTopContact.OUTSIDE;
    }
}
