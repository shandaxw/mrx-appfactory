package com.mrx.appfactory.common.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.mrx.appfactory.common.core.APIException;
import com.mrx.appfactory.common.core.APIResults;

/**
 * 
 * @author xuwen
 *
 */
public class TimeUtil {

    public final static String FORMAT_DATE = "yyyy-MM-dd";

    public final static String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    public final static String FORMAT_DATE_TIME_CONNECTED = "yyyyMMddHHmmss";
    
    public final static String FORMAT_YYYY_MM_DD_HH_MM_SS_SSS = "yyyyMMddHHmmssSSS";
    
    public static String getTimeString(String format){
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }
    
    /**
     * start<=end; if start>end throws APIExceptions.PARAM_INVALID
     * @param start
     * @param end
     * @throws APIException
     */
    public static void assertTimePeriod(java.util.Date start, java.util.Date end)
            throws APIException {
        if (start != null && end != null) {
            if (start.getTime() > end.getTime()) {
                throw new APIException(APIResults.PARAM_INVALID, "开始时间不能大于结束时间");
            }
        }
    }

    public static boolean isTimeType(Class<?> clazz) {
        if (java.sql.Date.class == clazz || java.util.Date.class == clazz
                || java.sql.Timestamp.class == clazz) {
            return true;
        }
        return false;
    }

    /**
     * parseTimestamp with format
     * @param timestampString
     * @param format
     * @return
     */
    public static Timestamp parseTimestamp(String timestampString, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            date = sdf.parse(timestampString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return toTimestamp(date);
    }
    
    /**
     * parseDate with format
     * @param dateString
     * @param format
     * @return
     */
    public static Date parse(String dateString, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date();
        try {
            date = sdf.parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 
     * @return
     */
    public static java.sql.Date currentSqlDate() {
        return new java.sql.Date(new Date().getTime());
    }

    /**
     * today 00:00:00
     * @return
     */
    public static Timestamp todayBegin() {
        return dateBegin(currentTimestamp());
    }

    /**
     * today 23:59:59
     * @return
     */
    public static Timestamp todayEnd() {
        return dateEnd(currentTimestamp());
    }

    /**
     * today hour:minute:0
     * @return
     */
    public static Timestamp secondBegin(Timestamp timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeStamp);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return toTimestamp(calendar.getTime());
    }

    /**
     * today hour:minute:59
     * @return
     */
    public static Timestamp secondEnd(Timestamp timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeStamp);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return toTimestamp(calendar.getTime());
    }

    /**
     * today 00:00:00
     * @param timeStamp
     * @return
     */
    public static Timestamp dateBegin(Timestamp timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeStamp);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return toTimestamp(calendar.getTime());
    }

    /**
     * today 23:59:59
     * @param timeStamp
     * @return
     */
    public static Timestamp dateEnd(Timestamp timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timeStamp);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 0);
        return toTimestamp(calendar.getTime());
    }
    /**
     * 当前时间
     * @return
     */
    public static Timestamp currentTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    public static String getTimeString(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat timeFormat = new SimpleDateFormat(format);
        return timeFormat.format(date);
    }

    public static String getDefaultTimeString(Date date) {
        if (date == null) {
            return null;
        }
        String formatString = TimeUtil.FORMAT_DATE;
        if (date instanceof Timestamp) {
            formatString = TimeUtil.FORMAT_DATE_TIME;
        }
        return getTimeString(date, formatString);
    }

    /**
     * 
     * @param date
     * @return
     */
    public static java.sql.Date toSqlDate(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Date(date.getTime());
    }

    /**
     * 
     * @param date
     * @return
     */
    public static java.sql.Timestamp toTimestamp(java.util.Date date) {
        if (date == null) {
            return null;
        }
        return new java.sql.Timestamp(date.getTime());
    }

    public static String getTimeString10() {
        return String.valueOf(Calendar.getInstance().getTimeInMillis() / 1000);
    }
    
}
