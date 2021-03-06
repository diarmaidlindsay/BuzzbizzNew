package pulseanddecibels.jp.buzbiznew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.model.ContactDetailsListItem;
import pulseanddecibels.jp.buzbiznew.util.SampleDataUtil;
import pulseanddecibels.jp.buzbiznew.util.Utils;

/**
 * Created by Diarmaid Lindsay on 2016/04/27.
 * Copyright Pulse and Decibels 2016
 */
public class ContactDetailsAdapter extends BaseAdapter {
    List<ContactDetailsListItem> contactDetailsList;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private ViewHolderItem viewHolder;

    public ContactDetailsAdapter(Context context, String telNum) {
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
        contactDetailsList = SampleDataUtil.getSampleContactDetails(20);
    }

    @Override
    public int getCount() {
        return contactDetailsList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactDetailsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContactDetailsListItem listItem = (ContactDetailsListItem) getItem(position);

        //because of multiple tabs, we cannot do the typical convertView.getTag() pattern

        viewHolder = new ViewHolderItem();
        if(listItem.getDate() == null) {
            //time item
            convertView = layoutInflater.inflate(R.layout.list_item_time, parent, false);
            viewHolder.time = (TextView) convertView.findViewById(R.id.contact_details_time);
            viewHolder.callState = (TextView) convertView.findViewById(R.id.contact_details_call_state);
            viewHolder.duration = (TextView) convertView.findViewById(R.id.contact_details_duration);
        } else {
            convertView = layoutInflater.inflate(R.layout.list_item_contact_details_date, parent, false);
            viewHolder.date = (TextView) convertView.findViewById(R.id.contact_details_date);
        }

        if(viewHolder.date == null) {
            //time item
            viewHolder.time.setText(listItem.getTime());
            viewHolder.callState.setTypeface(Utils.getIconMoonTypeFace(mContext));
            viewHolder.callState.setText(listItem.getCallState().getImageText());
            viewHolder.duration.setText(listItem.getDuration());
        } else {
            //date item
            viewHolder.date.setText(listItem.getDate());
        }

        return convertView;
    }

    static class ViewHolderItem {
        TextView date;
        TextView time;
        TextView callState;
        TextView duration;
    }
}
