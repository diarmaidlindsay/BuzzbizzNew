package pulseanddecibels.jp.buzbiznew.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
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
 *
 * Contact or History fragments, switched using the MainActivity
 * View Pager, by pressing the bottom two buttons.
 */
public class MainFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private final String LOG_TAG = getClass().getSimpleName();
//    private static Context mContext;
    //Uniquely identifies this page in the view pager
    private int mPage;
    private ViewPager topTabViewPager;

    public static MainFragment newInstance(Context context, int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        //mContext = context;
        //FragmentActivity activity = (FragmentActivity) mContext;
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
        Log.d(LOG_TAG, "onCreateView : "+mPage);
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        topTabViewPager = (ViewPager) view.findViewById(R.id.fragment_viewpager);
        topTabViewPager.setAdapter(mPage == MainActivity.CONTACTS_IDX ?
                new ContactsFragmentPagerAdapter(getChildFragmentManager(), getActivity()) :
                new HistoryFragmentPagerAdapter(getChildFragmentManager(), getActivity()));

        //update the main activity's view pager
        if(mPage == ((MainActivity)getActivity()).getCurrentSelectedTab()) {
            ((MainActivity)getActivity()).setAppBarTabs(topTabViewPager);
        }

        return view;
    }

    @Override
    /**
     * This event is called when a Fragment becomes visible.
     * Use this event to switch out the top tab view pager depending on
     * which Main Fragment is selected.
     */
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(topTabViewPager != null) {
            //update the main activity's view pager
            ((MainActivity)getActivity()).setAppBarTabs(topTabViewPager);
        }
    }
}
