package pulseanddecibels.jp.buzbiznew.model;

/**
 * Created by Diarmaid Lindsay on 2016/04/12.
 * Copyright Pulse and Decibels 2016
 */
public class HistoryListItem {
    private String date;
    private String telNumber;
    private String time;
    private CallState direction;
    private Long dateTimeMillis;

    public HistoryListItem(String date, String time, String telNumber, CallState direction, Long dateTimeMillis) {
        this.date = date;
        this.telNumber = telNumber;
        this.time = time;
        this.direction = direction;
        this.dateTimeMillis = dateTimeMillis;
    }

    public String getDate() { return date; }

    public String getTelNumber() {
        return telNumber;
    }

    public String getTime() {
        return time;
    }

    public CallState getDirection() {
        return direction;
    }

    public Long getDateTimeMillis() {
        return dateTimeMillis;
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
