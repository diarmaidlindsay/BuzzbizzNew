package pulseanddecibels.jp.buzbiznew.model;

import pulseanddecibels.jp.buzbiznew.util.Utils;

/**
 * Created by Diarmaid Lindsay on 2016/04/13.
 * Copyright Pulse and Decibels 2016
 */
public class ContactListItem {
    String telNumber;
    String nameKana;
    String nameKanji;

    public ContactListItem(String telNumber, String nameKana, String nameKanji) {
        this.telNumber = telNumber;
        this.nameKana = nameKana;
        this.nameKanji = nameKanji;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public String getNameKanji() {
        return nameKanji;
    }

    public String getNameKana() {
        return nameKana;
    }

    /**
     * Should be determined from the phone/extension number eventually
     */
    public TabTopContact getLineType() {
        //return random type for testing purposes.
        return TabTopContact.values()[Utils.randInt(0,TabTopContact.values().length-1)];
    }
}
