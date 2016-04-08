package pulseanddecibels.jp.buzbiznew.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.activity.MainActivity;
import pulseanddecibels.jp.buzbiznew.adapter.ContactsFragmentPagerAdapter;
import pulseanddecibels.jp.buzbiznew.adapter.HistoryFragmentPagerAdapter;

/**
 * Created by Diarmaid Lindsay on 2016/04/07.
 * Copyright Pulse and Decibels 2016
 */
public class MainFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private static Context mContext;
    private static int[] historyImages = {
            R.drawable.selector_history_all,
            R.drawable.selector_history_out,
            R.drawable.selector_history_in
    };
    private int mPage;

    public static MainFragment newInstance(Context context, int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        mContext = context;
        FragmentActivity activity = (FragmentActivity) mContext;
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        assert toolbar != null;
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        ViewPager topTabViewPager = (ViewPager) view.findViewById(R.id.fragment_viewpager);
        assert topTabViewPager != null;
        topTabViewPager.setAdapter(mPage == 1 ?
                new HistoryFragmentPagerAdapter(getChildFragmentManager(), getActivity()) :
                new ContactsFragmentPagerAdapter(getChildFragmentManager(), getActivity()));

        // Give the TabLayout the ViewPager
        TabLayout topTabLayout = (TabLayout) view.findViewById(R.id.app_bar_tabs);
        assert topTabLayout != null;
        topTabLayout.setupWithViewPager(topTabViewPager);

        for (int i = 0; i < topTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = topTabLayout.getTabAt(i);
            assert tab != null;
            tab.setIcon(historyImages[i]);
        }

        return view;
    }
}
