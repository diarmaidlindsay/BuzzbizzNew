package pulseanddecibels.jp.buzbiznew.model;

import pulseanddecibels.jp.buzbiznew.util.Util;

/**
 * Created by Diarmaid Lindsay on 2016/05/17.
 * Copyright Pulse and Decibels 2016
 */
public class HoldListItem {
    private String nameKanji;
    private String telNumber;
    private int holdingSeconds;

    public HoldListItem(String nameKanji, String telNumber, int holdingSeconds) {
        this.nameKanji = nameKanji;
        this.telNumber = telNumber;
        this.holdingSeconds = holdingSeconds;
    }

    public String getNameKanji() {
        return nameKanji;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getHoldingSeconds() {
        return Util.getTimeFromSecs(holdingSeconds);
    }

    public int getHoldImage() {
        return android.R.drawable.stat_notify_sync_noanim;
    }
}
