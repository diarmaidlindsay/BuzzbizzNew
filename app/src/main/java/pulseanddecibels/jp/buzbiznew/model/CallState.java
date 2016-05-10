package pulseanddecibels.jp.buzbiznew.model;

/**
 * Created by Diarmaid Lindsay on 2016/04/27.
 * Copyright Pulse and Decibels 2016
 */
public enum CallState {
    IN_CONNECTED(android.R.drawable.sym_call_incoming),
    OUT_CONNECTED(android.R.drawable.sym_call_outgoing),
    IN_MISSED(android.R.drawable.stat_sys_download),
    OUT_MISSED(android.R.drawable.stat_sys_upload);

    private int mImageResourceId;

    CallState(int imageResourceId) {
        mImageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
