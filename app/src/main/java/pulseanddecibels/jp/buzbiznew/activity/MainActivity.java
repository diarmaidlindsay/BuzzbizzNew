package pulseanddecibels.jp.buzbiznew.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.adapter.MainFragmentPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private int[] imageResId = {
            R.drawable.selector_main_contacts,
            R.drawable.selector_main_history
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton dialerButton = (FloatingActionButton) findViewById(R.id.button_dialer);
        assert dialerButton != null;
        dialerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO : Bring up dialer dialog
            }
        });

        ViewPager bottomTabViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        assert bottomTabViewPager != null;
        bottomTabViewPager.setAdapter(new MainFragmentPagerAdapter(getSupportFragmentManager(), this));

        TabLayout bottomTabLayout = (TabLayout) findViewById(R.id.bottom_bar_tabs);
        assert bottomTabLayout != null;
        bottomTabLayout.setupWithViewPager(bottomTabViewPager);

        for (int i = 0; i < bottomTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = bottomTabLayout.getTabAt(i);
            assert tab != null;
            tab.setIcon(imageResId[i]);
        }
    }

}
