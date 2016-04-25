package pulseanddecibels.jp.buzbiznew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.activity.MainActivity;
import pulseanddecibels.jp.buzbiznew.model.ContactListItem;
import pulseanddecibels.jp.buzbiznew.model.TabTopContact;
import pulseanddecibels.jp.buzbiznew.util.SampleDataUtil;
import pulseanddecibels.jp.buzbiznew.util.Util;

/**
 * Created by Diarmaid Lindsay on 2016/04/11.
 * Copyright Pulse and Decibels 2016
 *
 * SectionIndexer Info :
 * http://androidopentutorials.com/android-listview-fastscroll/
 */
public class ContactsAdapter extends BaseAdapter implements SectionIndexer {
    private final String LOG_TAG = getClass().getSimpleName();

    List<ContactListItem> contactsInside;
    List<ContactListItem> contactsOutside;
    //For fast scroller
    HashMap<String, Integer> mapIndexInside = new LinkedHashMap<>();
    HashMap<String, Integer> mapIndexOutside = new LinkedHashMap<>();
    //For fast scroller
    String[] sectionsInside;
    String[] sectionsOutside;
    //Sample Data
    private Context mContext;
    private LayoutInflater layoutInflater;
    private ViewHolderItem viewHolder;

    public ContactsAdapter(Context context) {
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
        contactsInside = SampleDataUtil.getSampleContacts(TabTopContact.INSIDE);
        contactsOutside = SampleDataUtil.getSampleContacts(TabTopContact.OUTSIDE);
        Collections.sort(contactsInside, new SortIgnoreCase());
        Collections.sort(contactsOutside, new SortIgnoreCase());

        initFastScroller(TabTopContact.INSIDE);
        initFastScroller(TabTopContact.OUTSIDE);
    }

    private void initFastScroller(TabTopContact tab) {
        List<ContactListItem> contacts = null;
        HashMap<String, Integer> mapIndex = null;
        //for fast scroller
        switch (tab) {
            case OUTSIDE:
                contacts = contactsOutside;
                mapIndex = mapIndexOutside;
                break;
            case INSIDE:
                contacts = contactsInside;
                mapIndex = mapIndexInside;
                break;
        }
        for (int x = 0; x < contacts.size(); x++) {
            String name = contacts.get(x).getNameKana();
            char ch = name.charAt(0);
            String first;

            if(Util.isKana(ch))
            {
                first = Util.lookupKana(ch);
            } else {
                first = name.substring(0, 1).toUpperCase(Locale.JAPAN);
            }

            // HashMap will prevent duplicates
            mapIndex.put(first, x);
        }

        List<String> sectionList = new ArrayList<>();
        sectionList.addAll(mapIndex.keySet());
        //sort sections
        Collections.sort(sectionList);
        switch (tab) {
            case OUTSIDE:
                sectionsOutside = sectionList.toArray(new String[sectionList.size()]);
                break;
            case INSIDE:
                sectionsInside = sectionList.toArray(new String[sectionList.size()]);
                break;
        }
    }

    @Override
    public int getCount() {
        switch (((MainActivity)mContext).getCurrentSelectedTopTabContact()) {
            case OUTSIDE:
                return contactsOutside.size();
            case INSIDE:
                return contactsInside.size();
        }
        return -1;
    }

    @Override
    public Object getItem(int position) {
        switch (((MainActivity)mContext).getCurrentSelectedTopTabContact()) {
            case OUTSIDE:
                return contactsOutside.get(position);
            case INSIDE:
                return contactsInside.get(position);
        }

        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_contact, parent, false);
            viewHolder = new ViewHolderItem();
            viewHolder.name = (TextView) convertView.findViewById(R.id.contact_name);
            viewHolder.icon = (ImageView) convertView.findViewById(R.id.contact_image);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        ContactListItem contactListItem = (ContactListItem) getItem(position);

        viewHolder.name.setText(contactListItem.getNameKanji());
        viewHolder.icon.setImageResource(android.R.drawable.btn_star);

        return convertView;
    }

    @Override
    public Object[] getSections() {
        switch (((MainActivity)mContext).getCurrentSelectedTopTabContact()) {
            case OUTSIDE:
                return sectionsOutside;
            case INSIDE:
                return sectionsInside;
        }

        return null;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        switch (((MainActivity)mContext).getCurrentSelectedTopTabContact()) {
            case OUTSIDE:
                return mapIndexOutside.get(sectionsOutside[sectionIndex]);
            case INSIDE:

                return mapIndexInside.get(sectionsInside[sectionIndex]);
        }

        return -1;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }

    static class ViewHolderItem {
        ImageView icon;
        TextView name;
    }

    private class SortIgnoreCase implements Comparator<ContactListItem> {
        public int compare(ContactListItem c1, ContactListItem c2) {
            return c1.getNameKanji().toLowerCase().compareTo(c2.getNameKanji().toLowerCase());
        }
    }
}
