package pulseanddecibels.jp.buzbiznew.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import hugo.weaving.DebugLog;
import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.adapter.MainFragmentPagerAdapter;

/**
 * Created by Diarmaid Lindsay on 2016/04/07.
 * Copyright Pulse and Decibels 2016
 */
public class MainActivity extends AppCompatActivity {

    //View Pager tab indexes
    public static final int CONTACTS_IDX = 0;
    public static final int HISTORY_IDX = 1;
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

    private TabLayout topTabLayout;
    private ViewPager bottomTabViewPager;

    @Override
    @DebugLog
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        assert toolbar != null;
        setSupportActionBar(toolbar);

        topTabLayout = (TabLayout) findViewById(R.id.app_bar_tabs);

        FloatingActionButton dialerButton = (FloatingActionButton) findViewById(R.id.button_dialer);
        assert dialerButton != null;
        dialerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO : Bring up dialer dialog
            }
        });

        bottomTabViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        assert bottomTabViewPager != null;
        bottomTabViewPager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager(), this));

        TabLayout bottomTabLayout = (TabLayout) findViewById(R.id.bottom_bar_tabs);
        assert bottomTabLayout != null;
        bottomTabLayout.setupWithViewPager(bottomTabViewPager);

        for (int i = 0; i < bottomTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = bottomTabLayout.getTabAt(i);
            assert tab != null;
            tab.setIcon(BOTTOM_TAB_ICONS[i]);
        }
    }

    /**
     * Is Contacts or History tab selected?
     */
    public int getCurrentSelectedTab() {
        if(bottomTabViewPager != null) {
            return bottomTabViewPager.getCurrentItem();
        }
        return -1;
    }

    /**
     * Change the top bars depending on if Contacts or History page is selected
     */
    public void setAppBarTabs(ViewPager topTabViewPager) {
        // Give the TabLayout the ViewPager
        topTabLayout.setupWithViewPager(topTabViewPager);
        for (int i = 0; i < topTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = topTabLayout.getTabAt(i);
            assert tab != null;
            //populate tabs with icons or text
            switch (getCurrentSelectedTab()) {
                case CONTACTS_IDX :
                    //Sometimes gets called before view pager switched out, so avoid IndexOutOfBoundsException
                    if(i < TOP_TAB_LABELS.length) {
                        tab.setText(TOP_TAB_LABELS[i]);
                    }
                    break;
                case HISTORY_IDX :
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
        outState.putInt(BOTTOM_TAB_POSITION, getCurrentSelectedTab());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        bottomTabViewPager.setCurrentItem(savedInstanceState.getInt(BOTTOM_TAB_POSITION));
    }
}
