package pulseanddecibels.jp.buzbiznew.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.activity.MainActivity;
import pulseanddecibels.jp.buzbiznew.model.CallState;
import pulseanddecibels.jp.buzbiznew.model.HistoryListItem;
import pulseanddecibels.jp.buzbiznew.util.DateUtils;
import pulseanddecibels.jp.buzbiznew.util.SampleDataUtil;
import pulseanddecibels.jp.buzbiznew.util.Utils;

/**
 * Created by Diarmaid Lindsay on 2016/04/12.
 * Copyright Pulse and Decibels 2016
 */
public class HistoryAdapter extends BaseAdapter {
    private final String LOG_TAG = getClass().getSimpleName();
    List<HistoryListItem> history;
    List<HistoryListItem> historyIn;
    List<HistoryListItem> historyOut;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private ViewHolderItem viewHolder;

    public HistoryAdapter(Context context) {
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
        history = SampleDataUtil.getSampleHistoryItems(100);
        historyIn = new ArrayList<>();
        historyOut = new ArrayList<>();
        historyIn.addAll(SampleDataUtil.getCurrentSampleHistoryItems(CallState.IN_CONNECTED));
        historyIn.addAll(SampleDataUtil.getCurrentSampleHistoryItems(CallState.IN_MISSED));
        Collections.sort(historyIn, getHistoryComparitor());
        historyIn = getHistoryListWithDateHeaders(historyIn);
        historyOut.addAll(SampleDataUtil.getCurrentSampleHistoryItems(CallState.OUT_CONNECTED));
        historyOut.addAll(SampleDataUtil.getCurrentSampleHistoryItems(CallState.OUT_MISSED));
        Collections.sort(historyOut, getHistoryComparitor());
        historyOut = getHistoryListWithDateHeaders(historyOut);
    }

    @Override
    public int getCount() {
        switch (((MainActivity)mContext).getCurrentSelectedTopTabHistory()) {
            case CALL_BOTH:
                return history.size();
            case CALL_OUT:
                return historyOut.size();
            case CALL_IN:
                return historyIn.size();
        }
        Log.e(LOG_TAG, "getCurrentSelectedTopTabHistory was not recognised, returning default");
        return history.size();
    }

    @Override
    public Object getItem(int position) {
        switch (((MainActivity)mContext).getCurrentSelectedTopTabHistory()) {
            case CALL_BOTH:
                return history.get(position);
            case CALL_OUT:
                return historyOut.get(position);
            case CALL_IN:
                return historyIn.get(position);
        }
        Log.e(LOG_TAG, "getCurrentSelectedTopTabHistory was not recognised, returning default");
        return history.get(position);
    }

    @Override
    public long getItemId(int position) {
        //eg tab 0, position 5 =
        //((0 + 1) * 1000) + 5
        return ((((MainActivity)mContext).getCurrentSelectedTopTabHistory().getIndex() + 1) * 1000) + position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HistoryListItem historyListItem = (HistoryListItem) getItem(position);

        //because of multiple tabs, we cannot do the typical convertView.getTag() pattern

        viewHolder = new ViewHolderItem();
        if(historyListItem.getDate() == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_history, parent, false);
            viewHolder.direction = (TextView) convertView.findViewById(R.id.history_direction);
            viewHolder.name = (TextView) convertView.findViewById(R.id.history_name);
            viewHolder.time = (TextView) convertView.findViewById(R.id.history_time);
            viewHolder.telNumber = (TextView) convertView.findViewById(R.id.history_number);
        } else {
            convertView = layoutInflater.inflate(R.layout.list_item_contact_details_date, parent, false);
            viewHolder.date = (TextView) convertView.findViewById(R.id.contact_details_date);
        }

        if(historyListItem.getDate() == null) {
            viewHolder.direction.setTypeface(Utils.getIconMoonTypeFace(mContext));
            viewHolder.direction.setText(historyListItem.getDirection().getImageText());
            //lookup name from phone number
            viewHolder.name.setText(SampleDataUtil.getContactForNumber(historyListItem.getTelNumber()).getNameKanji());
            viewHolder.time.setText(historyListItem.getTime());
            viewHolder.telNumber.setText(historyListItem.getTelNumber());
        } else {
            //date item
            viewHolder.date.setText(historyListItem.getDate());
        }

        return convertView;
    }

    private List<HistoryListItem> getHistoryListWithDateHeaders(final List<HistoryListItem> listWithoutHeaders) {
        List<HistoryListItem> listWithHeaders = new ArrayList<>();
        String currentDateHeader = "";

        for (HistoryListItem item : listWithoutHeaders) {
            String currentDate = DateUtils.getDateFromMillis(item.getDateTimeMillis());
            if(!currentDateHeader.equals(currentDate)) {
                currentDateHeader = currentDate;
                listWithHeaders.add(new HistoryListItem(currentDate, null, null, null, null));
            }
            listWithHeaders.add(item);
        }

        return listWithHeaders;
    }

    private Comparator<HistoryListItem> getHistoryComparitor() {
        return new Comparator<HistoryListItem>() {
            @Override
            public int compare(HistoryListItem lhs, HistoryListItem rhs) {
                if(lhs.getDateTimeMillis() < rhs.getDateTimeMillis()) {
                    return -1;
                } else if (lhs.getDateTimeMillis() > rhs.getDateTimeMillis()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
    }

    static class ViewHolderItem {
        TextView date;
        TextView direction;
        TextView name;
        TextView time;
        TextView telNumber;
    }
}
