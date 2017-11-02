package com.mrx.appfactory.common.util;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 
 * @author xuwen
 *
 */
public class DateEditor extends PropertyEditorSupport {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private DateFormat minuteFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    private Class<?> clazz;

    private boolean allowEmpty = true;

    public DateEditor(Class<?> clazz, boolean allowEmpty) {
        this.clazz = clazz;
        this.allowEmpty = allowEmpty;
    }

    /** 
     * Parse the Date from the given text, using the specified DateFormat. 
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (this.allowEmpty && (text == null || "".equals(text))) {
            // Treat empty String as null value.
            setValue(null);
        } else {
            try {
                /*
                if(text.contains(":"))
                    setValue(TimeUtil.toSqlDate(TIMEFORMAT.parse(text)));
                else
                */
                if (java.sql.Date.class.equals(clazz)) {
                    setValue(TimeUtil.toSqlDate(dateFormat.parse(text)));
                } else if (java.sql.Timestamp.class.equals(clazz)) {//支持 精确到 时/分/秒
                    try {
                        setValue(TimeUtil.toTimestamp(timeFormat.parse(text)));
                    } catch (Exception eTime) {
                        try {
                            setValue(TimeUtil.toTimestamp(minuteFormat.parse(text)));
                        } catch (Exception eMinute) {
                            setValue(TimeUtil.toTimestamp(dateFormat.parse(text)));
                        }
                    }

                } else if (java.util.Date.class.equals(clazz)) {
                    setValue(dateFormat.parse(text));
                } else {
                    throw new IllegalArgumentException(
                            "unsupported date type: " + clazz.toString());
                }
            } catch (ParseException ex) {
                throw new IllegalArgumentException("日期参数:" + text + ",格式不正确");
            }
        }
    }

    /** 
     * Format the Date as String, using the specified DateFormat. 
     */
    @Override
    public String getAsText() {
        Object value = getValue();
        if (value == null) {
            return null;
        }
        if (java.sql.Date.class.equals(clazz)) {
            return dateFormat.format(value);
        } else if (java.sql.Timestamp.class.equals(clazz)) {
            return timeFormat.format(value);
        } else if (java.util.Date.class.equals(clazz)) {
            return dateFormat.format(value);
        } else {
            return null;
        }
    }
}
