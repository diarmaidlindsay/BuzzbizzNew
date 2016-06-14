package pulseanddecibels.jp.buzbiznew.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by Diarmaid Lindsay on 2016/06/13.
 * Copyright Pulse and Decibels 2016
 */
public class ScrollerAreaView extends LinearLayout {
    private IndexScroller mScroller = null;

    public ScrollerAreaView(Context context) {
        super(context);
    }

    public ScrollerAreaView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollerAreaView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ScrollerAreaView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mScroller != null)
            //draw scroller inside sideview's canvas
            mScroller.drawSidebar(canvas);
    }

    public void setScroller(IndexScroller mScroller) {
        this.mScroller = mScroller;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //if scroller handled the touch event return true
        if (mScroller != null && mScroller.onTouchEvent(event)) {
            return true;
        }

        //else we handle ourselves
        return super.onTouchEvent(event);
    }
}
