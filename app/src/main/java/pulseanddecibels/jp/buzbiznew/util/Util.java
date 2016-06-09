package pulseanddecibels.jp.buzbiznew.util;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.joda.time.DateTimeZone;

import java.util.Locale;
import java.util.Random;

import pulseanddecibels.jp.buzbiznew.R;

/**
 * Created by Diarmaid Lindsay on 2016/04/12.
 * Copyright Pulse and Decibels 2016
 */
public class Util {
    public static final DateTimeZone JAPAN_TIME_ZONE = DateTimeZone.forOffsetHours(9);

    public static int randInt(int min, int max) {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        return rand.nextInt((max - min) + 1) + min;
    }

    public static boolean isKanji(char value) {
        return Character.UnicodeBlock.of(value)
                == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS;
    }

    public static boolean isKana(char value) {
        return Character.UnicodeBlock.of(value)
                == Character.UnicodeBlock.HIRAGANA ||
                Character.UnicodeBlock.of(value)
                == Character.UnicodeBlock.KATAKANA;
    }

    public static void goFullScreen(Activity activity) {
        if (Build.VERSION.SDK_INT < 19) { //19 or above api
            View v = activity.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else {
            //for lower api versions.
            View decorView = activity.getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    /**
     * Match a hiragana (left) or katakana (right) to
     * あかさたなはまやらわ
     * for address book lookup fast scroller
     */
    public static String lookupKana(char c) {
        if((c>=0x3040 && c<=0x304A)||(c>=0x30A0 && c<=0x30AA)) {
            return "あ";
        } else if ((c>=0x304B && c<=0x3054)||(c>=0x30AB && c<=0x30B4)) {
            return "か";
        } else if ((c>=0x3055 && c<=0x305E)||(c>=0x30B5 && c<=0x30BE)) {
            return "さ";
        } else if ((c>=0x305F && c<=0x3069)||(c>=0x30BF && c<=0x30C9)) {
            return "た";
        } else if ((c>=0x306A && c<=0x306E)||(c>=0x30CA && c<=0x30CE)) {
            return "な";
        } else if ((c>=0x306F && c<=0x307D)||(c>=0x30CF && c<=0x30DD)) {
            return "は";
        } else if ((c>=0x307E && c<=0x3082)||(c>=0x30DE && c<=0x30E2)) {
            return "ま";
        } else if ((c>=0x3083 && c<=0x3088)||(c>=0x30E3 && c<=0x30E8)) {
            return "や";
        } else if ((c>=0x3089 && c<=0x308D)||(c>=0x30E9 && c<=0x30ED)) {
            return "ら";
        } else {
            return "わ";
        }
    }

    public static void initDialpad(View dialpadLayout) {
        final TextView numberField = (TextView) dialpadLayout.findViewById(R.id.field_number_entry);
        final Button deleteButton = (Button) dialpadLayout.findViewById(R.id.button_delete);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = numberField.getText().toString();
                if(text.length() > 0) {
                    numberField.setText(text.substring(0, text.length()-1));
                }
            }
        });

        final int[] dialpadButtons = new int[] {
                R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3, R.id.button_4,
                R.id.button_5, R.id.button_6, R.id.button_7, R.id.button_8, R.id.button_9,
                R.id.button_hash, R.id.button_star
        };

        for(int buttonId : dialpadButtons) {
            final Button button = (Button) dialpadLayout.findViewById(buttonId);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    numberField.setText(numberField.getText().toString() + button.getText().toString());
                }
            });
        }
    }

    /**
     * Given seconds, return time in format of 00:00:00
     */
    public static String getTimeFromSecs(int totalSeconds) {
        int seconds = totalSeconds % 60;
        int totalMinutes = totalSeconds / 60;
        int minutes = totalMinutes % 60;
        int hours = totalMinutes / 60;

        if (totalMinutes > 0) {
            if(hours > 0) {
                String secString = seconds < 10 ? "0"+seconds : ""+seconds;
                String minString = minutes < 10 ? "0"+minutes : ""+minutes;
                String hourString = hours < 10 ? "0"+hours : ""+hours;
                return String.format(Locale.JAPAN, "%s:%s:%s", hourString, minString, secString);
            } else {
                // Less than 01:00:00 (00:59:59 etc)
                String secString = seconds < 10 ? "0"+seconds : ""+seconds;
                String minString = totalMinutes < 10 ? "0"+totalMinutes : ""+totalMinutes;
                return String.format(Locale.JAPAN, "%s:%s", minString, secString);
            }

        } else {
            // Less than 01:00 (00:09, 00:59, etc)
            String secString = totalSeconds < 10 ? "0"+totalSeconds : ""+totalSeconds;
            return String.format(Locale.JAPAN, "00:%s", secString);
        }
    }

    public static String lookupKana(String s) {
        return lookupKana(s.charAt(0));
    }
}
