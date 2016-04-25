package pulseanddecibels.jp.buzbiznew.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.adapter.MainFragmentPagerAdapter;
import pulseanddecibels.jp.buzbiznew.model.TabBottom;
import pulseanddecibels.jp.buzbiznew.model.TabTopContact;
import pulseanddecibels.jp.buzbiznew.model.TabTopHistory;

/**
 * Created by Diarmaid Lindsay on 2016/04/07.
 * Copyright Pulse and Decibels 2016
 */
public class MainActivity extends AppCompatActivity {

    //Save/Restore instance state keys
    private static final String BOTTOM_TAB_POSITION = "BOTTOM_POS";
    private final String LOG_TAG = getClass().getSimpleName();
    private final int[] BOTTOM_TAB_ICONS = {
            R.drawable.selector_main_contacts,
            R.drawable.selector_main_history
    };

    private final int[] TOP_TAB_ICONS = {
            R.drawable.selector_history_all,
            R.drawable.selector_history_out,
            R.drawable.selector_history_in
    };

    private final String[] TOP_TAB_LABELS = {
            "外線",
            "内線"
    };

    private TabLayout mTopTabLayout;
    private ViewPager mTopTabViewPager;
    private ViewPager mBottomTabViewPager;
    private LinearLayout dialPadLayout;
    private FloatingActionButton floatingDialerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        assert toolbar != null;
        setSupportActionBar(toolbar);

        mTopTabLayout = (TabLayout) findViewById(R.id.app_bar_tabs);

        //initialise dial pad layout
        dialPadLayout = (LinearLayout) findViewById(R.id.dialpad);
        final TextView numberField = (TextView) dialPadLayout.findViewById(R.id.field_number_entry);
        final Button deleteButton = (Button) dialPadLayout.findViewById(R.id.button_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = numberField.getText().toString();
                if(text.length() > 0) {
                    numberField.setText(text.substring(0, text.length()-1));
                }
            }
        });


        final int[] dialpadButtons = new int[] {
                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4,
                R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9,
                R.id.button_hash, R.id.button_star
        };

        for(int buttonId : dialpadButtons) {
            final Button button = (Button) dialPadLayout.findViewById(buttonId);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberField.setText(numberField.getText().toString() + button.getText().toString());
                }
            });
        }

        floatingDialerButton = (FloatingActionButton) findViewById(R.id.button_dialer);
        assert floatingDialerButton != null;
        floatingDialerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show dialpad (hidden by default)
                dialPadLayout.setVisibility(View.VISIBLE);
                floatingDialerButton.setVisibility(View.GONE);
            }
        });

        mBottomTabViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        assert mBottomTabViewPager != null;
        mBottomTabViewPager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager(), this));

        TabLayout bottomTabLayout = (TabLayout) findViewById(R.id.bottom_bar_tabs);
        assert bottomTabLayout != null;
        bottomTabLayout.setupWithViewPager(mBottomTabViewPager);

        for (int i = 0; i < bottomTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = bottomTabLayout.getTabAt(i);
            assert tab != null;
            tab.setIcon(BOTTOM_TAB_ICONS[i]);
        }
    }

    /**
     * Is Contacts or History tab selected?
     */
    public TabBottom getCurrentSelectedBottomTab() {
        if(mBottomTabViewPager != null) {
            return TabBottom.getTab(mBottomTabViewPager.getCurrentItem());
        }
        Log.e(LOG_TAG, "mBottomTabViewPager was null, returning default item");
        return TabBottom.HISTORY;
    }

    public TabTopContact getCurrentSelectedTopTabContact() {
        if(mTopTabViewPager != null) {
            return TabTopContact.getTab(mTopTabViewPager.getCurrentItem());
        }
        Log.e(LOG_TAG, "mTopTabViewPager was null, returning default item");
        return TabTopContact.OUTSIDE;
    }

    public TabTopHistory getCurrentSelectedTopTabHistory() {
        if(mTopTabViewPager != null) {
            return TabTopHistory.getTab(mTopTabViewPager.getCurrentItem());
        }
        Log.e(LOG_TAG, "mTopTabViewPager was null, returning default item");
        return TabTopHistory.CALL_BOTH;
    }

    /**
     * Change the top bars depending on if Contacts or History page is selected
     */
    public void setAppBarTabs(ViewPager topTabViewPager) {
        // Give the TabLayout the ViewPager
        mTopTabViewPager = topTabViewPager;
        mTopTabLayout.setupWithViewPager(mTopTabViewPager);
        for (int i = 0; i < mTopTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTopTabLayout.getTabAt(i);
            assert tab != null;
            //populate tabs with icons or text
            switch (getCurrentSelectedBottomTab()) {
                case CONTACTS:
                    //Sometimes gets called before view pager switched out, so avoid IndexOutOfBoundsException
                    if(i < TOP_TAB_LABELS.length) {
                        tab.setText(TOP_TAB_LABELS[i]);
                    }
                    break;
                case HISTORY:
                    //Sometimes gets called before view pager switched out, so avoid IndexOutOfBoundsException
                    if(i < TOP_TAB_ICONS.length) {
                        tab.setIcon(TOP_TAB_ICONS[i]);
                    }
                    break;
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(BOTTOM_TAB_POSITION, getCurrentSelectedBottomTab().getIndex());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mBottomTabViewPager.setCurrentItem(savedInstanceState.getInt(BOTTOM_TAB_POSITION));
    }

    @Override
    public void onBackPressed() {
        if(dialPadLayout != null && floatingDialerButton != null && dialPadLayout.getVisibility() == View.VISIBLE) {
            dialPadLayout.setVisibility(View.GONE);
            floatingDialerButton.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }
}
