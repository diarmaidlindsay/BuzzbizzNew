package pulseanddecibels.jp.buzbiznew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.model.ContactDetailsListItem;
import pulseanddecibels.jp.buzbiznew.util.SampleDataUtil;

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
        contactDetailsList = SampleDataUtil.getSampleContactDetails(Integer.parseInt(telNum));
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

        if(listItem.getDate() == null) {
            //time item
            convertView = layoutInflater.inflate(R.layout.list_item_contact_details_time, parent, false);
            viewHolder = new ViewHolderItem();
            viewHolder.time = (TextView) convertView.findViewById(R.id.contact_details_time);
            viewHolder.callState = (ImageView) convertView.findViewById(R.id.contact_details_call_state);
            viewHolder.duration = (TextView) convertView.findViewById(R.id.contact_details_duration);
        } else {
            //date item
            convertView = layoutInflater.inflate(R.layout.list_item_contact_details_date, parent, false);
            viewHolder = new ViewHolderItem();
            viewHolder.date = (TextView) convertView.findViewById(R.id.contact_details_date);
        }

        if(viewHolder.date == null) {
            //time item
            viewHolder.time.setText(listItem.getTime());
            viewHolder.callState.setImageResource(listItem.getCallState().getImageResourceId());
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
        ImageView callState;
        TextView duration;
    }
}
