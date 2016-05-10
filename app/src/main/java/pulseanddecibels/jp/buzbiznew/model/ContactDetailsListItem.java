package pulseanddecibels.jp.buzbiznew.model;

/**
 * Created by Diarmaid Lindsay on 2016/04/27.
 * Copyright Pulse and Decibels 2016
 */
public class ContactDetailsListItem {
    String date;
    String time;
    CallState callState;
    String duration;

    public ContactDetailsListItem(String date, String time, CallState callState, String duration) {
        this.date = date;
        this.time = time;
        this.callState = callState;
        this.duration = duration;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public CallState getCallState() {
        return callState;
    }

    public String getDuration() {
        return duration;
    }
}
