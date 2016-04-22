package pulseanddecibels.jp.buzbiznew.model;

/**
 * Created by Diarmaid Lindsay on 2016/04/13.
 * Copyright Pulse and Decibels 2016
 */
public class ContactListItem {
    int telNum;
    String nameKana;
    String nameKanji;

    public ContactListItem(int telNum, String nameKana, String nameKanji) {
        this.telNum = telNum;
        this.nameKana = nameKana;
        this.nameKanji = nameKanji;
    }

    public int getTelNum() {
        return telNum;
    }

    public String getNameKanji() {
        return nameKanji;
    }

    public String getNameKana() {
        return nameKana;
    }
}
