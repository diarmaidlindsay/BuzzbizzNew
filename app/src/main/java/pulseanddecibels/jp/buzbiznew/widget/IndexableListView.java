package pulseanddecibels.jp.buzbiznew.widget;

/*
 * Copyright 2011 woozzu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.widget.ListAdapter;
import android.widget.ListView;

public class IndexableListView extends ListView {

    private boolean mIsFastScrollEnabled = false;
    private IndexScroller mScroller = null;
    private ScrollerAreaView mScrollerAreaView = null;
    private GestureDetector mGestureDetector = null;

    public IndexableListView(Context context) {
        super(context);
    }

    public IndexableListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IndexableListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setScrollerAreaView(ScrollerAreaView scrollerAreaView) {
        scrollerAreaView.setWillNotDraw(false);
        mScrollerAreaView = scrollerAreaView;
    }

    @Override
    public boolean isFastScrollEnabled() {
        return mIsFastScrollEnabled;
    }

    @Override
    public void setFastScrollEnabled(boolean enabled) {
        mIsFastScrollEnabled = enabled;
        if (mIsFastScrollEnabled) {
            if (mScroller == null)
                mScroller = new IndexScroller(getContext(), this);
                if(mScrollerAreaView != null) {
                    mScrollerAreaView.setScroller(mScroller);
                    mScroller.show();
                } else {
                    Log.e("IndexableListView", "mScrollerAreaView is null, so the scroller won't display");
                }
        } else {
            if (mScroller != null) {
                mScroller.hide();
                mScroller = null;
                if(mScrollerAreaView != null) {
                    mScrollerAreaView.setScroller(null);
                }
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if(mScrollerAreaView != null) {
            mScrollerAreaView.invalidate();
        }
        if (mScroller != null) {
            //draw preview inside listview's canvas
            mScroller.drawPreview(canvas);
        }
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
        if (mScroller != null)
            mScroller.setAdapter(adapter);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mScroller != null)
            mScroller.onSizeChanged(w, h, oldw, oldh);
    }

}
