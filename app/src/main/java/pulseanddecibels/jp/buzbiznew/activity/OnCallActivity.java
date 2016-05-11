package pulseanddecibels.jp.buzbiznew.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_on_call);

        Bundle arguments = getIntent().getExtras();
        final int telNumber = arguments.getInt("telNumber");
        final String nameKanji = arguments.getString("nameKanji");
        final String nameKana = arguments.getString("nameKana");

        TextView telNumberField = (TextView) findViewById(R.id.call_number);
        telNumberField.setText(String.format(Locale.JAPAN, "%d", telNumber));
        TextView nameKanjiField = (TextView) findViewById(R.id.call_name_kanji);
        nameKanjiField.setText(nameKanji);
        TextView nameKanaField = (TextView) findViewById(R.id.call_name_kana);
        nameKanaField.setText(nameKana);

        timerField = (TextView) findViewById(R.id.call_timer);
        startTimer();
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
