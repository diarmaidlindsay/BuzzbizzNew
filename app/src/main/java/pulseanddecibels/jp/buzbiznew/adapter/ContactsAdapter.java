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
import pulseanddecibels.jp.buzbiznew.model.ContactListItem;
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

    List<ContactListItem> contacts;
    //For fast scroller
    HashMap<String, Integer> mapIndex = new LinkedHashMap<>();
    //For fast scroller
    String[] sections;
    //Sample Data
    private Context mContext;
    private LayoutInflater layoutInflater;
    private ViewHolderItem viewHolder;

    public ContactsAdapter(Context context) {
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
        contacts = SampleDataUtil.getSampleContacts();
        Collections.sort(contacts, new SortIgnoreCase());

        initFastScroller();
    }

    private void initFastScroller() {
        //for fast scroller
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
        sections = sectionList.toArray(new String[sectionList.size()]);
    }

    private void initFastScrollerRomaji() {
        //for fast scroller
        for (int x = 0; x < contacts.size(); x++) {
            String name = contacts.get(x).getNameKana();
            String ch = name.substring(0, 1);
            ch = ch.toUpperCase(Locale.US);

            // HashMap will prevent duplicates
            mapIndex.put(ch, x);
        }

        sections = mapIndex.keySet().toArray(new String[mapIndex.keySet().size()]);
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    @Override
    public Object getItem(int position) {

        return contacts.get(position);
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
        return sections;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return mapIndex.get(sections[sectionIndex]);
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
