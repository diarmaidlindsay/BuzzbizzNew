package pulseanddecibels.jp.buzbiznew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.model.HoldListItem;
import pulseanddecibels.jp.buzbiznew.util.SampleDataUtil;
import pulseanddecibels.jp.buzbiznew.util.Utils;

/**
 * Created by Diarmaid Lindsay on 2016/05/18.
 * Copyright Pulse and Decibels 2016
 */
public class HoldAdapter extends BaseAdapter {
    private final String LOG_TAG = getClass().getSimpleName();
    List<HoldListItem> holdListItems;
    private Context mContext;
    private LayoutInflater layoutInflater;
    private ViewHolderItem viewHolder;

    public HoldAdapter(Context context) {
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
        holdListItems = SampleDataUtil.getSampleHoldList(Utils.randInt(1, 8));
    }

    @Override
    public int getCount() {
        return holdListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return holdListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_hold, parent, false);
            viewHolder = new ViewHolderItem();
            viewHolder.nameKanji = (TextView) convertView.findViewById(R.id.hold_name);
            viewHolder.telNumber = (TextView) convertView.findViewById(R.id.hold_number);
            viewHolder.holdingTime = (TextView) convertView.findViewById(R.id.hold_time);
            viewHolder.holdingIcon = (ImageButton) convertView.findViewById(R.id.hold_icon);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderItem) convertView.getTag();
        }

        HoldListItem holdListItem = (HoldListItem) getItem(position);
        viewHolder.nameKanji.setText(holdListItem.getNameKanji());
        viewHolder.telNumber.setText(holdListItem.getTelNumber());
        viewHolder.holdingTime.setText(holdListItem.getHoldingSeconds());
        viewHolder.holdingIcon.setImageResource(holdListItem.getHoldImage());

        return convertView;
    }

    static class ViewHolderItem {
        TextView nameKanji;
        TextView telNumber;
        TextView holdingTime;
        ImageView holdingIcon;
    }
}
