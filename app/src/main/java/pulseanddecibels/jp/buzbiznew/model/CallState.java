package pulseanddecibels.jp.buzbiznew.model;

/**
 * Created by Diarmaid Lindsay on 2016/04/27.
 * Copyright Pulse and Decibels 2016
 */
public enum CallState {
    IN_CONNECTED("k"),
    OUT_CONNECTED("u"),
    IN_MISSED("l"),
    OUT_MISSED("t");

    private String mImageText; //icomoon font code

    CallState(String imageText) {
        mImageText = imageText;
    }

    public String getImageText() {
        return mImageText;
    }
}
