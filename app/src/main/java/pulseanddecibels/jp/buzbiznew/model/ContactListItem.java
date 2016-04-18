package pulseanddecibels.jp.buzbiznew.model;

/**
 * Created by Diarmaid Lindsay on 2016/04/13.
 * Copyright Pulse and Decibels 2016
 */
public class ContactListItem {
    int telNum;
    String name;

    public ContactListItem(int telNum, String name) {
        this.telNum = telNum;
        this.name = name;
    }

    public int getTelNum() {
        return telNum;
    }

    public String getName() {
        return name;
    }
}
