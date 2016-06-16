package pulseanddecibels.jp.buzbiznew.model;

/**
 * Created by Diarmaid Lindsay on 2016/04/12.
 * Copyright Pulse and Decibels 2016
 */
public class HistoryListItem {
    private String telNumber;
    private String time;
    private CallState direction;

    public HistoryListItem(String telNumber, String time, CallState direction) {
        this.telNumber = telNumber;
        this.time = time;
        this.direction = direction;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getTime() {
        return time;
    }

    public CallState getDirection() {
        return direction;
    }

    /**
     * Should be determined from the phone/extension number eventually
     */
    public TabTopContact getLineType() {
        if(Integer.parseInt(telNumber) < 1000) {
            return TabTopContact.INSIDE;
        }
        return TabTopContact.OUTSIDE;
    }
}
