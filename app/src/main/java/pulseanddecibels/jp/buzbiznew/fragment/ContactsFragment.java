package pulseanddecibels.jp.buzbiznew.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.adapter.ContactsAdapter;
import pulseanddecibels.jp.buzbiznew.widget.IndexableListView;
import pulseanddecibels.jp.buzbiznew.widget.ScrollerAreaView;

/**
 * Created by Diarmaid Lindsay on 2016/04/06.
 * Copyright Pulse and Decibels 2016
 */
public class ContactsFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private ContactsAdapter adapter;

    public static ContactsFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ContactsFragment fragment = new ContactsFragment();
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
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        IndexableListView contactsList = (IndexableListView) view.findViewById(R.id.list_contacts);
        ScrollerAreaView scrollerAreaView = (ScrollerAreaView) view.findViewById(R.id.scroller_space);
        contactsList.setScrollerAreaView(scrollerAreaView);
        contactsList.setFastScrollEnabled(true);
        adapter = new ContactsAdapter(getActivity());
        contactsList.setAdapter(adapter);

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
        if(adapter != null && isVisibleToUser) {
            //refresh contacts list after tab change
            adapter.notifyDataSetInvalidated();
        }
    }
}
