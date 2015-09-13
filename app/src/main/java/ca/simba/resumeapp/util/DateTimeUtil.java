package ca.simba.resumeapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by tmast_000 on 9/11/2015.
 */
public class DateTimeUtil {




        public static String getCurrentTime() {
            // returns the current time in 24hr hh:mm:ss format
            Date time = Calendar.getInstance().getTime();
            SimpleDateFormat aFormat = new SimpleDateFormat("HH:mm:ss");
            String formattedDate = aFormat.format(time);
            return formattedDate;
        }

        public static String toMonthYearTextFormat(String date) {
            SimpleDateFormat currentFormat = new SimpleDateFormat("yyyy-MM-F");
            SimpleDateFormat desiredFormat = new SimpleDateFormat("MMM yyyy");

            Date mDate;
            String formattedTime;
            try {
                mDate = currentFormat.parse(date);
                formattedTime = desiredFormat.format(mDate);
            } catch (ParseException e) {
                formattedTime = "0:00 AM";
            }
            return formattedTime;
        }

        public static String apply12HrTimeFormat(String time) {
            // converts times from 24hr hh:mm:ss format to 12hr hh:mm a format
            SimpleDateFormat currentFormat = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat desiredFormat = new SimpleDateFormat("hh:mm a");
            Date mTime;
            String formattedTime;
            try {
                mTime = currentFormat.parse(time);
                formattedTime = desiredFormat.format(mTime);
            } catch (ParseException e) {
                formattedTime = "0:00 AM";
            }
            return formattedTime;
        };


}
