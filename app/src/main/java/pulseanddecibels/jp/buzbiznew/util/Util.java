package pulseanddecibels.jp.buzbiznew.util;

import org.joda.time.DateTimeZone;

import java.util.Random;

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

    public static String lookupKana(String s) {
        return lookupKana(s.charAt(0));
    }
}
