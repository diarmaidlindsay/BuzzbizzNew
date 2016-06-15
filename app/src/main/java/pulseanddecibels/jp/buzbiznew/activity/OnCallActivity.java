package pulseanddecibels.jp.buzbiznew.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;

import pulseanddecibels.jp.buzbiznew.R;
import pulseanddecibels.jp.buzbiznew.util.Util;

/**
 * Created by Diarmaid Lindsay on 2016/05/10.
 * Copyright Pulse and Decibels 2016
 */
public class OnCallActivity extends Activity {
    private static final Handler HANDLER = new Handler();
    TextView timerField;
    CallTimer timer;
    LinearLayout dialpad;
    LinearLayout callButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_on_call);

        Bundle arguments = getIntent().getExtras();
        final String telNumber = arguments.getString("telNumber");
        final String nameKanji = arguments.getString("nameKanji");
        final String nameKana = arguments.getString("nameKana");

        TextView telNumberField = (TextView) findViewById(R.id.call_number);
        telNumberField.setText(String.format(Locale.JAPAN, "%s", telNumber));
        TextView nameKanjiField = (TextView) findViewById(R.id.call_name_kanji);
        nameKanjiField.setText(nameKanji);
        TextView nameKanaField = (TextView) findViewById(R.id.call_name_kana);
        nameKanaField.setText(nameKana);

        timerField = (TextView) findViewById(R.id.call_timer);

        dialpad = (LinearLayout) findViewById(R.id.dialpad_content);
        Util.initDialpad(dialpad);
        callButtons = (LinearLayout) findViewById(R.id.call_content);

        Button muteButton = (Button) callButtons.findViewById(R.id.button_mute);
        Button speakerButton = (Button) callButtons.findViewById(R.id.button_speaker);
        Button transferButton = (Button) callButtons.findViewById(R.id.button_transfer);
        Button dialpadButton = (Button) callButtons.findViewById(R.id.button_dialpad);
        dialpadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleVisible();
            }
        });
        Button holdButton = (Button) callButtons.findViewById(R.id.button_hold);
        holdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //when hold button pressed, go back to Main Activity (as specified in Manifest)
                NavUtils.navigateUpFromSameTask(OnCallActivity.this);
            }
        });

        Button hangupButton = (Button) callButtons.findViewById(R.id.button_hangup);

        setFont(muteButton);
        setFont(speakerButton);
        setFont(transferButton);
        setFont(dialpadButton);
        setFont(holdButton);
        setFont(hangupButton);

        Button callButton = (Button) dialpad.findViewById(R.id.button_call);
        //hide call button when we're actually on a call
        callButton.setVisibility(View.GONE);

        startTimer();
    }

    private void setFont(Button button) {
        button.setTypeface(Util.getIconMoonTypeFace(this));
    }

    /**
     * Toggle visibility of keypad and calling control buttons
     */
    public void toggleVisible() {
        if(dialpad.getVisibility() == View.VISIBLE) {
            dialpad.setVisibility(View.GONE);
            callButtons.setVisibility(View.VISIBLE);
        } else {
            callButtons.setVisibility(View.GONE);
            dialpad.setVisibility(View.VISIBLE);
        }
    }

    public void startTimer() {
        timer = new CallTimer();
        timer.start();
    }

    public void stopTimer() {
        if(timer != null) {
            timer.stop();
        }
    }

    public void setDisplayCallerTimer(String time) {
        timerField.setText(time);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTimer();
    }

    @Override
    public void onBackPressed() {
        //hide dialpad when back pressed
        if(dialpad.getVisibility() == View.VISIBLE) {
            toggleVisible();
        } else {
            super.onBackPressed();
        }
    }

    private class CallTimer {
        private final SimpleDateFormat shortTimeFormat	= new SimpleDateFormat("mm:ss",		Locale.JAPANESE);
        private final SimpleDateFormat longTimeFormat	= new SimpleDateFormat("HH:mm:ss",	Locale.JAPANESE);
        private long startTime;
        private long callTime;
        public CallTimer() {
            shortTimeFormat.setTimeZone(Util.JAPAN_TIME_ZONE.toTimeZone());
            longTimeFormat.setTimeZone(Util.JAPAN_TIME_ZONE.toTimeZone());
        }

        public void start() {
            startTime = System.currentTimeMillis();

            final Runnable run = new Runnable() {
                @Override
                public void run() {
                    long currentTime = System.currentTimeMillis();
                    long diff = currentTime - startTime;

                    if (diff >= 3600000) {
                        OnCallActivity.this.setDisplayCallerTimer(longTimeFormat.format(diff));
                    } else {
                        OnCallActivity.this.setDisplayCallerTimer(shortTimeFormat.format(diff));
                    }

                    HANDLER.postDelayed(this, 1000);
                }
            };
            HANDLER.postDelayed(run, 1000);
        }

        public void stop() {
            long endTime = System.currentTimeMillis();
            callTime = endTime - startTime;
            //TODO : store + display call time somewhere
        }
    }
}
