package pulseanddecibels.jp.buzbiznew.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Locale;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.adapter.ContactDetailsAdapter;
import pulseanddecibels.jp.buzbiznew.model.ContactListItem;
import pulseanddecibels.jp.buzbiznew.util.SampleDataUtil;

/**
 * Created by Diarmaid Lindsay on 2016/04/28.
 * Copyright Pulse and Decibels 2016
 */
public class ContactDetailsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_contact_details);

        Bundle arguments = getIntent().getExtras();
        final String telNumber = arguments.getString("telNumber");

        final ContactListItem contactForNumber = SampleDataUtil.getContactForNumber(telNumber);
        TextView contactName = (TextView) findViewById(R.id.contact_details_name);
        contactName.setText(contactForNumber.getNameKanji());
        TextView contactNumber = (TextView) findViewById(R.id.contact_details_number);
        contactNumber.setText(String.format(Locale.JAPAN, "%s", contactForNumber.getTelNumber()));
        Button callButton = (Button) findViewById(R.id.button_call);
        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ContactDetailsActivity.this, OnCallActivity.class);
                intent.putExtra("telNumber", contactForNumber.getTelNumber());
                intent.putExtra("nameKanji", contactForNumber.getNameKanji());
                intent.putExtra("nameKana", contactForNumber.getNameKana());
                startActivity(intent);
            }
        });

        ListView detailsList = (ListView) findViewById(R.id.list_contact_details);
        ContactDetailsAdapter detailsAdapter = new ContactDetailsAdapter(this, telNumber);
        detailsList.setAdapter(detailsAdapter);
    }
}
