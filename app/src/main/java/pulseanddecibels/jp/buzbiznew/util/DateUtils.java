package pulseanddecibels.jp.buzbiznew.util;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.Locale;

/**
 * Created by Diarmaid Lindsay on 2016/06/16.
 * Copyright Pulse and Decibels 2016
 */
public class DateUtils {
    public static final DateTimeZone JAPAN_TIME_ZONE = DateTimeZone.forOffsetHours(9);

    /**
     * Offset plus or minus today's date, used for sample data generation.
     */
    public static long getMillisecondsForDayOffset(int offset, boolean plus) {
        DateTime dateTime = new DateTime(DateUtils.JAPAN_TIME_ZONE);
        if(plus) {
            dateTime = dateTime.plusDays(offset);
        } else {
            dateTime = dateTime.minusDays(offset);
        }

        dateTime = setRandomTime(dateTime);

        return dateTime.getMillis();
    }

    private static DateTime setRandomTime(DateTime dateTime) {
        int hour = Util.randInt(0, 23);
        int minute = Util.randInt(0, 59);
        dateTime = dateTime.withHourOfDay(hour).withMinuteOfHour(minute);
        return dateTime;
    }

    public static String getDateFromMillis(long millis) {
        DateTime dateTime = new DateTime(millis, DateUtils.JAPAN_TIME_ZONE);
        return String.format(Locale.JAPAN, "%d.%s.%s", dateTime.getYear(), Util.num2DigitString(dateTime.getMonthOfYear()), Util.num2DigitString(dateTime.getDayOfMonth()));
    }

    public static String getTimeFromMillis(long millis) {
        DateTime dateTime = new DateTime(millis, DateUtils.JAPAN_TIME_ZONE);
        return String.format(Locale.JAPAN, "%s:%s", Util.num2DigitString(dateTime.getHourOfDay()), Util.num2DigitString(dateTime.getMinuteOfHour()));
    }
}
